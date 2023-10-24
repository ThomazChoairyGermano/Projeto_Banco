package com.br.banco.service;

import com.br.banco.entity.Veiculo;
import com.br.banco.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> listaTodos(){
        return repository.findAll();
    }

    public Veiculo create(Veiculo veiculo) {

        return repository.save(veiculo);
    }

    public Veiculo update(Long id, Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return repository.findAll();
    }

    public Optional<Veiculo> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
