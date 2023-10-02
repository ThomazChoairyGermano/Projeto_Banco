package com.br.banco.service;

import com.br.banco.entity.Funcionario;
import com.br.banco.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listaTodos(){
        return repository.findAll();
    }

    public List<Funcionario> listaPorNome(String nome){

        return repository.findByNomeContainsIgnoreCase(nome);
    }

    public Funcionario create(Funcionario funcionario) {

        return repository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
