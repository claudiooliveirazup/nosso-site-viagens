package br.com.zup.controller.dtos;

import br.com.zup.entity.Pais;

import javax.validation.constraints.NotBlank;

public class CadastrarPaisRequest {
    @NotBlank
    private String nome;

    public Pais toModel(){
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
