package com.br.banco.dto;

import com.br.banco.entity.Funcionario;
import lombok.Data;

@Data
public class FuncionarioDto {

    private Long id;
    private String cpf;

    public FuncionarioDto(){
    }

    public FuncionarioDto(Long id, String cpf) {
        this.id = id;
        this.cpf = cpf;
    }

    public FuncionarioDto(Funcionario funcionario) {
        id = funcionario.getId();
        cpf = funcionario.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
