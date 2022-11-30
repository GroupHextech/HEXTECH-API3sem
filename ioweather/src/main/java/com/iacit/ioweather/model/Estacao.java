package com.iacit.ioweather.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
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

	@NotEmpty(message="O código WMO da estação não deve ser nulo")
    @Size(max=10, message="Número máximo de caracteres é de 10.")
    private String estacaoWMO;

	@NotEmpty(message="O nome da estaçao nãoo deve ser nulo")
	@Size(max=60, message="Número máximo de caracteres é de 60.")
	private String nomeEstacao;
	
	@NotEmpty(message="Latitude não pode ser vazio.")
	@DecimalMin(value="-90.00000000", message="A latitude da estação deve ser entre -90.00000000 a 90.00000000")
	@DecimalMax(value="90.00000000", message="A latitude da estação deve ser entre -90.00000000 a 90.00000000")
	private String latitude;
	
	@NotEmpty(message="Longitude não pode ser vazio.")
	@DecimalMin(value="-180.00000000", message="A latitude da estação deve ser entre -180.00000000 a 180.00000000")
	@DecimalMax(value="180.00000000", message="A latitude da estação deve ser entre -180.00000000 a 180.00000000")
	private String longitude;
	
	@NotNull(message="A altitude não deve ser nula")
	@DecimalMin(value="0.01", message=" A altitude da Estaçao não pode ser menor que 0,01")
	private BigDecimal altitude;
	
	@NotNull(message="A data de fundaçao não deve ser nula")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	
	@NotEmpty(message="O id do estado não pode estar vazio")
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
	public String getEstacaoWMO() {
	return estacaoWMO;
	}
	public void setEstacaoWMO(String estacaoWMO) {
		this.estacaoWMO = estacaoWMO;
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
