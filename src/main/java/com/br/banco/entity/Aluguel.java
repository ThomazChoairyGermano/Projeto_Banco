package com.br.banco.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluguel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contato> emails;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "aluguelveiculo_veiculo",
            joinColumns = @JoinColumn(name = "id_aluguelveiculo"),
            inverseJoinColumns = @JoinColumn(name = "id_veiculo"))
    private Set<Veiculo> veiculos = new HashSet<>();

    public Aluguel(Long id, String nomeCliente) {
        this.id = id;
        this.Cliente = nomeCliente;
    }
}