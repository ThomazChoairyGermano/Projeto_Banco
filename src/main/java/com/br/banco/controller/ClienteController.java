package com.br.banco.controller;

import com.br.banco.dto.ClienteDto;
import com.br.banco.entity.Cliente;
import com.br.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/listar-todos")
    public List<Cliente> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/listar-por-nome/{nome}")
    public List<Cliente> buscarNome(@PathVariable String nome) {
        return service.listaPorNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clienteCreated = service.create(cliente);

        return ResponseEntity.status(201).body(clienteCreated);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente) {
        Cliente clienteUpdated = service.update(cliente);

        if (clienteUpdated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(clienteUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Optional<Cliente> cliente = service.findById(id);
        return cliente.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/dto/{id}")
    public ResponseEntity<ClienteDto> findId(@PathVariable Long id) {
        Optional<ClienteDto> clienteDto = Optional.ofNullable(service.findId(id));
        return clienteDto.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}


