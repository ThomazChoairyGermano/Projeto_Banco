package com.br.banco.service;

import com.br.banco.entity.Contato;
import com.br.banco.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

    public List<Contato> listaTodos(){
        return repository.findAll();
    }

    public Contato create(Contato contatos) {

        Contato contato = null;
        return repository.save(contato);
    }

    public Contato update(Long id, Contato contatos) {
        Contato contato = null;
        return repository.save(contato);
    }

    public List<Contato> findAll() {
        return repository.findAll();
    }

    public Optional<Contato> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
