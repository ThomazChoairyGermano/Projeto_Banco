package com.br.banco.controller;

import com.br.banco.dto.ClienteDto;
import com.br.banco.dto.FuncionarioDto;
import com.br.banco.entity.Funcionario;
import com.br.banco.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> findAll() {
        return service.listaTodos();
    }

    @GetMapping("/listar-por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> buscarNome(@PathVariable String nome) {
        return service.listaPorNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCreated = service.create(funcionario);

        return ResponseEntity.status(201).body(funcionarioCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCreated = service.create(funcionario);

        return ResponseEntity.status(201).body(funcionarioCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Funcionario> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @GetMapping(value = "/{id}")
    public FuncionarioDto findId(@PathVariable Long id){
        return service.findId(id);
    }


}
