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
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Pagamento>> findAll() {
        List<Pagamento> pagamentos = service.listaTodos();
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> create(@RequestBody Pagamento pagamento) {
        Pagamento pagamentoCreated = service.create(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        Optional<Pagamento> updatedPagamento = Optional.ofNullable(service.update(id, pagamento));

        if (updatedPagamento.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedPagamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> findById(@PathVariable Long id) {
        Optional<Pagamento> pagamento = service.findById(id);
        return pagamento.map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

