package br.com.zup.controller.dtos;

import javax.validation.constraints.NotBlank;

public class CadastrarPaisRequest {
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
