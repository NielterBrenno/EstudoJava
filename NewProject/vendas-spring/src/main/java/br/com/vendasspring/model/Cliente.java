package br.com.vendasspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Cliente {
	
	public Cliente(String nome, String identificacao, String sexo) {
		this.nome=nome;
		this.identificacao=identificacao;
		this.sexo=sexo;
	}

	@Id
	@GeneratedValue
	
	private Long id;
	
	private String nome;
	
	@Column(nullable=false, length=11)
	private String identificacao;
	
	private String sexo;


	
}
