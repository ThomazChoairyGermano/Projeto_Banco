package com.br.banco.controller;

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
    private FuncionarioService service;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = service.listaTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/listar-por-nome/{nome}")
    public ResponseEntity<List<Funcionario>> buscarNome(@PathVariable String nome) {
        List<Funcionario> funcionarios = service.listaPorNome(nome);
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioCreated = service.create(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Optional<Funcionario> updatedFuncionario = Optional.ofNullable(service.update(id, funcionario));

        if (updatedFuncionario.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedFuncionario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = service.findById(id);
        return funcionario.map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping(value = "/dto/{id}")
    public ResponseEntity<FuncionarioDto> findId(@PathVariable Long id) {
        Optional<FuncionarioDto> funcionarioDto = Optional.ofNullable(service.findId(id));
        return funcionarioDto.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
