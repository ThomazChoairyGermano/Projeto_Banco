package com.br.banco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private double valor;

    public Pagamento(Long id, String tipo, double valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }


}