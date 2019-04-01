package br.com.vendasspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Transacao {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToOne
	private Produto produto;
	
	private Double valor;
}
