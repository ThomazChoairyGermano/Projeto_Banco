package com.br.banco.service;

import com.br.banco.entity.Pagamento;
import com.br.banco.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public List<Pagamento> listaTodos(){
        return repository.findAll();
    }

    public Pagamento create(Pagamento pagamento) {

        return repository.save(pagamento);
    }

    public Pagamento update(Pagamento pagamento) {
        return repository.save(pagamento);
    }

    public List<Pagamento> findAll() {
        return repository.findAll();
    }

    public Optional<Pagamento> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
