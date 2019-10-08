package br.com.shrobo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ShAtivacaoXProdutoXMaquina")
public class ShAtualizaAtivacao implements Serializable {
	
	@Id
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "ativacao")
	private ShAtivacao shAtivacao;

	@Column(name = "atualizado")
	private Integer shAtivado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShAtivacao getShAtivacao() {
		return shAtivacao;
	}

	public void setShAtivacao(ShAtivacao shAtivacao) {
		this.shAtivacao = shAtivacao;
	}

	public Integer getShAtivado() {
		return shAtivado;
	}

	public void setShAtivado(Integer shAtivado) {
		this.shAtivado = shAtivado;
	}
	
	
}
