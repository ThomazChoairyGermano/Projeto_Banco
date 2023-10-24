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
    private AluguelService service;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Aluguel>> findAll() {
        List<Aluguel> alugueis = service.listaTodos();
        return ResponseEntity.ok(alugueis);
    }

    @PostMapping
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguel) {
        Aluguel aluguelCreated = service.create(aluguel);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluguel> update(@PathVariable Long id, @RequestBody Aluguel aluguel) {
        Optional<Aluguel> updatedAluguel = Optional.ofNullable(service.update(id, aluguel));

        if (updatedAluguel.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedAluguel.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluguel> findById(@PathVariable Long id) {
        Optional<Aluguel> aluguel = service.findById(id);
        return aluguel.map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
