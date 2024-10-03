package com.algaworks.socialbooks.resources;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.services.AutoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutoresResource {

    @Autowired
    private AutoresService autoresService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Autor>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(autoresService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(
           @Valid @RequestBody Autor autor){
        autor = autoresService.salvar(autor);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Autor>> buscar(@PathVariable("id") Long id){
        Optional<Autor> autor = autoresService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(autor);
    }

}
