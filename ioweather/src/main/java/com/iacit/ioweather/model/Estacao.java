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
	private Long idEstacao;
	
	@NotEmpty(message="O nome da estaçao nao deve ser nulo")
	@Size(max=60, message="Número máximo de caracteres é de 60.")
	private String nomeEstacao;
	
	@NotEmpty(message="Latitude não pode ser vazio.")
	private String latitude;
	
	@NotEmpty(message="Longitude não pode ser vazio.")
	private String longitude;
	
	@NotNull(message="A altitude nao deve ser nula")
	@DecimalMin(value="0.01", message=" A altitude da Estaçao nao pode ser menor que 0,01")
	private BigDecimal altitude;
	
	@NotNull(message="A data de fundaçao nao deve ser nula")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	@NotEmpty(message="O id do estado nao pode estar vazio")
	private String idEstadoEstacao;
	
	//Getters and Setters
	public Long getIdEstacao() {
		return idEstacao;
	}
	public void setIdEstacao(Long idEstacao) {
		this.idEstacao = idEstacao;
	}
	public String getNomeEstacao() {
		return nomeEstacao;
	}
	public void setNomeEstacao(String nomeEstacao) {
		this.nomeEstacao = nomeEstacao;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getAltitude() {
		return altitude;
	}
	public void setAltitude(BigDecimal altitude) {
		this.altitude = altitude;
	}
	public Date getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public String getIdEstadoEstacao() {
		return idEstadoEstacao;
	}
	public void setIdEstadoEstacao(String idEstadoEstacao) {
		this.idEstadoEstacao = idEstadoEstacao;
	}
	

	

}
