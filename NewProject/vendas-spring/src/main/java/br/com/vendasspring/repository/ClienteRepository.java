package br.com.vendasspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.vendasspring.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query("select cli from Cliente cli where cli.nome =:nome")
	public Cliente buscaPorNome(@Param("nome") String nome);
	
	@Query("Select cli from Cliente cli")
	public List<Cliente> buscarTodos();
}