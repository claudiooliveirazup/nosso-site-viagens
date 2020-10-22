package br.com.zup.controller.dtos;

import br.com.zup.annotation.NomeUnico;
import br.com.zup.entity.Companhia;
import br.com.zup.entity.Pais;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompanhiaRequest {
	@NomeUnico(domainClass = Companhia.class, fieldName = "nome")
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

	@Transactional
	public Companhia toModel(@NotNull EntityManager entityManager){

		Pais pais = entityManager.find(Pais.class, this.idPais);
		Assert.notNull(pais, "Pais não encontrado.");

		return new Companhia(this.nome, pais);
	}


}
