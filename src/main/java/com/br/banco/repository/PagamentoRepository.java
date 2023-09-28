package com.br.banco.repository;

import com.br.banco.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository
        extends JpaRepository<Pagamento, Long> {
}
