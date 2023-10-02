package com.br.banco.service;

import com.br.banco.entity.Contatos;
import com.br.banco.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatosService {

    @Autowired
    private ContatosRepository repository;

    public List<Contatos> listaTodos(){
        return repository.findAll();
    }

    public Contatos create(Contatos contatos) {

        return repository.save(contatos);
    }

    public Contatos update(Contatos contatos) {
        return repository.save(contatos);
    }

    public List<Contatos> findAll() {
        return repository.findAll();
    }

    public Optional<Contatos> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
