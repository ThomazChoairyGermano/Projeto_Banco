package com.br.banco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @OneToMany
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @OneToMany
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;
}
