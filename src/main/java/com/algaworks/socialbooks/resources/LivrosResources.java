package com.algaworks.socialbooks.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResources {

	@Autowired
	private LivrosRepository livrosRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {
		return livrosRepository.findAll();
    }

	@RequestMapping(method = RequestMethod.POST)
	//RequestBody para poder fazer o parse e colocar as informações desse do objeto livro
	public void salvar(@RequestBody Livro livro){
		livrosRepository.save(livro);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Livro buscar(@PathVariable("id") Long id){
		return this.livrosRepository.findById(id).orElse(null);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable ("id") Long id){
		livrosRepository.deleteById(id);
	}

	@PutMapping(value ="/{id}")
	public void atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livrosRepository.save(livro);
	}

}