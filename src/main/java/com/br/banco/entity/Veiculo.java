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
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private String placa;

    public Veiculo(Long id, String tipo, String placa) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
    }


}
