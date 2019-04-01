package br.com.vendasspring.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.vendasspring.model.Cliente;
import br.com.vendasspring.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Setter @Getter
	private List<Cliente> clientes;	
	@Setter @Getter
	private Cliente cliente = new Cliente() ;
	
	@PostConstruct
	public void init() {
		setClientes(clienteRepository.findAll());
		cliente = new Cliente();
	}
	
}
