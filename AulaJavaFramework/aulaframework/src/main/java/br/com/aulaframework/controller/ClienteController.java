package br.com.aulaframework.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;

import br.com.aulaframework.model.Cliente;
import br.com.aulaframework.model.Contato;
import br.com.aulaframework.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Setter @Getter
	private List<Cliente> clientes;	
	@Setter @Getter
	private Cliente cliente = new Cliente() ;	
	@Setter @Getter
	private Contato contato = new Contato();	
	@Setter @Getter
	private boolean modoEdicao = false;
	
	@PostConstruct
	public void init() {
		setClientes(clienteRepository.findAll());
		cliente = new Cliente();
	}
	
	public void salvar() {
		clienteRepository.save(cliente);
		if(!modoEdicao) {
			clientes.add(cliente);
		}
		cliente = new Cliente();
		modoEdicao=false;
	}
	

	public void excluir(Cliente cliente) {
		clienteRepository.delete(cliente);
		clientes.remove(cliente);
		modoEdicao=false;
	}
	
	public void cancelar() {
		cliente = new Cliente();
		modoEdicao=false;
	}
	
	public void editar(Cliente cliente) {
		setCliente(cliente);
		modoEdicao=true;
	}
	
	public void adicionarContato() {
		
		contato.setCliente(cliente);		
		cliente.getContatos().add(contato);
		contato = new Contato();
		
	}
	
	public void excluirContato(Contato contato) {
		cliente.getContatos().remove(contato);
	}
	
	

 
}
