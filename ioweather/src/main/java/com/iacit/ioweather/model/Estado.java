package com.iacit.ioweather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Estado {

	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer idEstado;
	
	@NotEmpty (message="O valor Estado nao pode ser nulo")
	@Size (max=100, message="Valor máximo de 100 caracteres no campo Estado")
	private String nomeEstado;
	
	@NotEmpty (message="O valor da Sigla do Estado nao pode ser nulo")
	@Size (max=2, message="Valor máximo de 2 caracteres no campo Sigla do Estado")
	private String siglaEstado;
	
	@NotNull (message="O valor da Regiao nao pode ser nulo")
	@Size (max=2, message="Valor máximo de 2 caracteres no campo Regiao")
	private Integer idRegiaoEstado;

	
	
	
	//Getters and Setters
	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
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

	public Integer getIdRegiaoEstado() {
		return idRegiaoEstado;
	}

	public void setIdRegiaoEstado(Integer idRegiaoEstado) {
		this.idRegiaoEstado = idRegiaoEstado;
	}
	
	
	
}

