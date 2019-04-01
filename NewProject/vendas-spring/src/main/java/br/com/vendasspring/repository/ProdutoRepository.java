package br.com.vendasspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendasspring.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
