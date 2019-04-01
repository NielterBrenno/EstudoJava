package br.com.vendasspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendasspring.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
