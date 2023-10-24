package com.br.banco.service;

import com.br.banco.entity.Aluguel;
import com.br.banco.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository repository;

    public List<Aluguel> listaTodos(){
        return repository.findAll();
    }

    public Aluguel create(Aluguel aluguel) {

        return repository.save(aluguel);
    }

    public Aluguel update(Long id, Aluguel aluguel) {
        return repository.save(aluguel);
    }

    public List<Aluguel> findAll() {
        return repository.findAll();
    }

    public Optional<Aluguel> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
