package com.br.banco.dto;

import com.br.banco.entity.Cliente;
import lombok.Data;

@Data
public class ClienteDto {

    private Long id;
    private String cpf;

    public ClienteDto(){
    }

    public ClienteDto(Long id, String cpf) {
        this.id = id;
        this.cpf = cpf;
    }

    public ClienteDto(Cliente cliente) {
        id = cliente.getId();
        cpf = cliente.getCpf();
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
