package com.br.banco.repository;

import com.br.banco.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository
        extends JpaRepository<Aluguel, Long> {
}
