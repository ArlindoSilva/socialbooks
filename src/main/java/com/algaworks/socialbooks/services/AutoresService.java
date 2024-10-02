package com.algaworks.socialbooks.services;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    public List<Autor> listar(){
        return autoresRepository.findAll();
    }

    public Autor salvar(Autor autor){
        if (autor.getId() != null) {
        Optional<Autor> a = autoresRepository.findById(autor.getId());

            if (a.isPresent()){
                throw new AutorExistenteException("O autor já existe");
            }
        }
        return autoresRepository.save(autor);
    }

    public Optional<Autor> buscar(Long id) {
        Optional<Autor> autor = autoresRepository.findById(id);

        if (!autor.isPresent()){
            throw new AutorNaoEncontradoException("Autor não encontrado");
        }
        return autor;
    }

}
