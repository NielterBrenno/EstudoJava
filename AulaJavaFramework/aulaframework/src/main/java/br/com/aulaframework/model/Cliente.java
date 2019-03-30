package br.com.aulaframework.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Proxy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Cliente {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cliente")
	private List<Contato> contatos = new ArrayList<>();
	
			
	
	@JoinColumn
	@ManyToOne
	private Estado estado;

	
	public Cliente(String nome) {
		setNome(nome);
	} 
	

}
