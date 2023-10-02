package com.br.banco.controller;

import com.br.banco.entity.Aluguel;
import com.br.banco.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    AluguelService service;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluguel> findAll() {
        return service.listaTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguel) {
        Aluguel aluguelCreated = service.create(aluguel);

        return ResponseEntity.status(201).body(aluguelCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluguel> update(@RequestBody Aluguel aluguel) {
        Aluguel aluguelCreated = service.create(aluguel);

        return ResponseEntity.status(201).body(aluguelCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluguel> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
