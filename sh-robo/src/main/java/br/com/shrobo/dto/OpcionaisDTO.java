package br.com.shrobo.dto;

import java.io.Serializable;

public class OpcionaisDTO implements Serializable{


	private static final long serialVersionUID = 1795671261464524159L;

	private Long id;
	private Integer codigoModulo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCodigoModulo() {
		return codigoModulo;
	}
	public void setCodigoModulo(Integer codigoModulo) {
		this.codigoModulo = codigoModulo;
	}
	
	

}
