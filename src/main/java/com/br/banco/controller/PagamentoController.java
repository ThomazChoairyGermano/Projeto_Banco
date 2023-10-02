package com.br.banco.controller;

import com.br.banco.entity.Pagamento;
import com.br.banco.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamennto")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> findAll() {
        return service.listaTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pagamento> create(@RequestBody Pagamento pagamento) {
        Pagamento pagamentoCreated = service.create(pagamento);

        return ResponseEntity.status(201).body(pagamentoCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pagamento> update(@RequestBody Pagamento pagamento) {
        Pagamento pagamentoCreated = service.create(pagamento);

        return ResponseEntity.status(201).body(pagamentoCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pagamento> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
