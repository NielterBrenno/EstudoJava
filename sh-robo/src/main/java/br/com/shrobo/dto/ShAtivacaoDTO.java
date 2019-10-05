package br.com.shrobo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ShAtivacaoDTO implements Serializable {

	private static final long serialVersionUID = -6053464453758290042L;

	private Long maquina;
	private Long sigCad;
	private String serial;
	private Date dtValidade;
	private List<OpcionaisDTO> opcionais;
	private String ativacao;
	
	

	public String getAtivacao() {
		return ativacao;
	}

	public void setAtivacao(String ativacao) {
		this.ativacao = ativacao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Long getMaquina() {
		return maquina;
	}

	public void setMaquina(Long maquina) {
		this.maquina = maquina;
	}

	public Long getSigCad() {
		return sigCad;
	}

	public void setSigCad(Long sigCad) {
		this.sigCad = sigCad;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public List<OpcionaisDTO> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<OpcionaisDTO> opcionais) {
		this.opcionais = opcionais;
	}

}
