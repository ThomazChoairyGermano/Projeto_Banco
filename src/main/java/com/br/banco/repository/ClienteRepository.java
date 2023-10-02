package com.br.banco.repository;

import com.br.banco.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContainsIgnoreCase(String nome);
}
