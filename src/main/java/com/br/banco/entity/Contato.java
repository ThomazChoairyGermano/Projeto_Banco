package com.br.banco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder(toBuilder = true)
//@NoArgsConstructor
//@AllArgsConstructor
@Entity

public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    private String email;
    private String telefone;

    public Contato(Long id, String endereco, String email, String telefone) {
        this.id = id;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

}
