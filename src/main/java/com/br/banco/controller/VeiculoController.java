package com.br.banco.controller;

import com.br.banco.entity.Veiculo;
import com.br.banco.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Veiculo>> findAll() {
        List<Veiculo> veiculos = service.listaTodos();
        return ResponseEntity.ok(veiculos);
    }

    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo) {
        Veiculo veiculoCreated = service.create(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Optional<Veiculo> updatedVeiculo = Optional.ofNullable(service.update(id, veiculo));

        if (updatedVeiculo.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedVeiculo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id) {
        Optional<Veiculo> veiculo = service.findById(id);
        return veiculo.map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

