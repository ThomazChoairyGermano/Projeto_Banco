package com.br.banco.controller;

import com.br.banco.entity.Contato;
import com.br.banco.service.ContatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

    @Autowired
    private ContatosService service;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Contato>> findAll() {
        List<Contato> contatos = service.listaTodos();
        return ResponseEntity.ok(contatos);
    }

    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contatos) {
        Contato contatosCreated = service.create(contatos);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatosCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contatos) {
        Optional<Contato> updatedContatos = Optional.ofNullable(service.update(id, contatos));

        if (updatedContatos.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedContatos.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> findById(@PathVariable Long id) {
        Optional<Contato> contatos = service.findById(id);
        return contatos.map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

