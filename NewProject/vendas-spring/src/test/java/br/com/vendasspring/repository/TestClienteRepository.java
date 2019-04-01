package br.com.vendasspring.repository;


import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vendasspring.model.Cliente;
import lombok.Data;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Data

public class TestClienteRepository {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		EntityManager entityManager;
		
		
		@Test
		public void testSalvar() {
			
			Cliente cli = new Cliente("Jão","1234","Masc");
			Cliente cliSalvo = clienteRepository.save(cli);
			Assert.assertNotNull(cliSalvo.getClass());
		}
	
		
		@Test
		public void testBuscarPorNome(){
			Cliente cli =  new Cliente("Jão","1234","Masc");
			entityManager.persist(cli);
		Cliente cliEncontrado = clienteRepository.buscaPorNome("Jão");
			
			assertThat(cliEncontrado.getNome()).isEqualTo(cli.getNome());
		
		}
}
	