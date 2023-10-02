package com.br.banco.entity;

<<<<<<< HEAD
public class Funcionario {
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cpf;

    @ManyToOne
    @JoinColumn(name = "contatos_id")
    private Contatos contatos;

>>>>>>> entidades
}
