package com.iacit.ioweather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstado;

	@NotEmpty(message = "O campo 'Estado' não pode ser nulo.")
	@Size(max = 100, message = "A quantidade máxima permitida no campo 'Estado' é de 100 caracteres.")
	private String nomeEstado;

	@NotEmpty(message = "O campo 'Sigla do Estado' não pode ser nulo.")
	@Size(max = 2, message = "A quantidade máxima permitida no campo 'Siga do Estado' é de 2 caracteres.")
	private String siglaEstado;

	@NotEmpty(message = "O campo 'Região' não pode ser nulo.")
	@Size(max = 2, message = "A quantidade máxima permitida no campo 'Região' é de 2 caracteres.")
	private String idRegiaoEstado;

	// Getters and Setters
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getIdRegiaoEstado() {
		return idRegiaoEstado;
	}

	public void setIdRegiaoEstado(String idRegiaoEstado) {
		this.idRegiaoEstado = idRegiaoEstado;
	}

}
