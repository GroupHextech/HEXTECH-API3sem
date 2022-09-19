package com.iacit.ioweather.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Estacao {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idEstacaibr;
	
	@NotEmpty(message="O nome da estaçao nao deve ser nulo")
	@Size(max=60, message="Número máximo de caracteres é de 60.")
	private String nomeEstacao;
	
<<<<<<< HEAD
	@NotNull(message="A latitude nao deve ser nula")
	@DecimalMin(value="0.01", message=" A latitude da Estaçao nao pode ser menor que 0,01")
	private BigDecimal latitudeEstacao;
	
	@NotNull(message="A longitude nao deve ser nula")
	@DecimalMin(value="0.01", message=" A longitude da Estaçao nao pode ser menor que 0,01")
	private BigDecimal longitudeEstacao;
=======
	@NotEmpty(message="Latitude não pode ser vazio.")
	private String latitudeEstacao;
	
	@NotEmpty(message="Longitude não pode ser vazio.")
	private String longitudeEstacao;
>>>>>>> origin/sprint1_CaioSendreto
	
	@NotNull(message="A altitude nao deve ser nula")
	@DecimalMin(value="0.01", message=" A altitude da Estaçao nao pode ser menor que 0,01")
	private BigDecimal altitudeEstacao;
	
	@NotNull(message="A data de fundaçao nao deve ser nula")
<<<<<<< HEAD
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	@NotNull(message="O id do estado nao pode estar vazio")
	private Long idEstado;
=======
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	@NotEmpty(message="O id do estado nao pode estar vazio")
	private String idEstado;
>>>>>>> origin/sprint1_CaioSendreto
	
	//Getters and Setters
	public Long getIdEstacaibr() {
		return idEstacaibr;
	}
	public void setIdEstacaibr(Long idEstacaibr) {
		this.idEstacaibr = idEstacaibr;
	}
	public String getNomeEstacao() {
		return nomeEstacao;
	}
	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}
<<<<<<< HEAD
	public BigDecimal getLatitudeEstacao() {
		return latitudeEstacao;
	}
	public void setLatitudeEstacao(BigDecimal latitudeEstacao) {
		this.latitudeEstacao = latitudeEstacao;
	}
	public BigDecimal getLongitudeEstacao() {
		return longitudeEstacao;
	}
	public void setLongitudeEstacao(BigDecimal longitudeEstacao) {
=======
	public String getLatitudeEstacao() {
		return latitudeEstacao;
	}
	public void setLatitudeEstacao(String latitudeEstacao) {
		this.latitudeEstacao = latitudeEstacao;
	}
	public String getLongitudeEstacao() {
		return longitudeEstacao;
	}
	public void setLongitudeEstacao(String longitudeEstacao) {
>>>>>>> origin/sprint1_CaioSendreto
		this.longitudeEstacao = longitudeEstacao;
	}
	public BigDecimal getAltitudeEstacao() {
		return altitudeEstacao;
	}
	public void setAltitudeEstacao(BigDecimal altitudeEstacao) {
		this.altitudeEstacao = altitudeEstacao;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
<<<<<<< HEAD
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
=======
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
>>>>>>> origin/sprint1_CaioSendreto
		this.idEstado = idEstado;
	}
	
	
	//Metodos
	

}
