package com.br.banco.repository;

import com.br.banco.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository
    extends JpaRepository<Veiculo, Long> {

}
