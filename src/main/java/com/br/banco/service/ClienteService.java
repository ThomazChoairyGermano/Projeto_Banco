package com.br.banco.service;

import com.br.banco.dto.ClienteDto;
import com.br.banco.entity.Cliente;
import com.br.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listaTodos(){
        return repository.findAll();
    }

    public List<Cliente> listaPorNome(String nome){

        return repository.findByNomeContainsIgnoreCase(nome);
    }

    public Cliente create(Cliente cliente) {

        return repository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ClienteDto findId(Long id) {
        Cliente entity = repository.findById(id).get();
        ClienteDto dto = new ClienteDto(entity);
        return dto;
    }

}
