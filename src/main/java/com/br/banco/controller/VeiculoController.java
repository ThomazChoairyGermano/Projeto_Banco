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
    VeiculoService service;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> findAll() {
        return service.listaTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo) {
        Veiculo veiculoCreated = service.create(veiculo);

        return ResponseEntity.status(201).body(veiculoCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Veiculo> update(@RequestBody Veiculo veiculo) {
        Veiculo veiculoCreated = service.create(veiculo);

        return ResponseEntity.status(201).body(veiculoCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Veiculo> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
