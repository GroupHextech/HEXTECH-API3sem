package com.iacit.ioweather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegiao;

	@NotEmpty(message = "O campo 'Região' não pode ser nulo.")
	@Size(max = 60, message = "A quantidade máxima de caracteres permitida é 60.")
	private String nomeRegiao;

	@NotEmpty(message = "O nome da estaçao não pode ser nulo.")
	@Size(max = 60, message = "A quantidade máxima de caracteres permitida é 60.")
	private String siglaRegiao;

	// Getters and Setters
	public Long getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getNomeRegiao() {
		return nomeRegiao;
	}

	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}

	public String getSiglaRegiao() {
		return siglaRegiao;
	}

	public void setSiglaRegiao(String siglaRegiao) {
		this.siglaRegiao = siglaRegiao;
	}

}
