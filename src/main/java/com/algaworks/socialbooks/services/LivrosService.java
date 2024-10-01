package com.algaworks.socialbooks.services;

import com.algaworks.socialbooks.domain.Comentario;
import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.ComentarioRepository;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Livro> listar(){
        return livrosRepository.findAll();
    }

    public Livro buscar(Long id) {
        Livro livro = livrosRepository.getReferenceById(id);
        if (livro == null) {
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
        }
        return livro;
    }

    public Livro salvar(Livro livro){
        livro.setId(null);
        return livrosRepository.saveAndFlush(livro);
    }

    public void deletar(Long id) {
        try {
            livrosRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado.");
        }
    }

    public void atualizar(Livro livro){
        verificarExistencia(livro);
        livrosRepository.saveAndFlush(livro);
    }

    private void verificarExistencia(Livro livro){
        buscar(livro.getId());
    }

    public Comentario salvarComentario(Long livroId, Comentario comentario){
        Livro livro = buscar(livroId);

        comentario.setLivro(livro);
        comentario.setData(new Date());

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarComentarios(Long livroId){
        Livro livro = buscar(livroId);
        return livro.getComentarios();
    }
}
