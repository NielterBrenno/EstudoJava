package br.com.shrobo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sh_vw_ativacao_opcionais")
public class Opcionais implements Serializable {

	private static final long serialVersionUID = 2255235778055562063L;
	
	@Id
	private Long id;
	
	@Column(name = "codigo_modulo")
	private Integer codigoModulo;
	
	@ManyToOne
	@JoinColumn(name = "maquina")
	private ShAtivacao shAtivacao;

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

	public ShAtivacao getShAtivacao() {
		return shAtivacao;
	}

	public void setShAtivacao(ShAtivacao shAtivacao) {
		this.shAtivacao = shAtivacao;
	}





}
