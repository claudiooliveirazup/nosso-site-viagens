package br.com.zup.controller.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompanhiaRequest {

	@NotBlank
	private String nome;
	
	@NotNull
	private Long idPais;

	@Override
	public String toString() {
		return "NovaCompanhiaRequest [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}	
}
