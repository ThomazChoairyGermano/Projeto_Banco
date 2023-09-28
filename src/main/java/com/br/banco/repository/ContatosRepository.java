package com.br.banco.repository;

import com.br.banco.entity.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepository
        extends JpaRepository<Contatos, Long> {
}
