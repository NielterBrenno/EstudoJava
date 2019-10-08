package br.com.shrobo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.shrobo.domain.ShAtivacao;

public interface ShAtivacaoRepository extends JpaRepository<ShAtivacao, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "update ShAtivacaoXProdutoXMaquina set ativacao = ?1, "
				 + " atualizado = 1 where Ctrl_ID = ?2 and ShProdutoXMaquina_ID = ?3 ",
			nativeQuery = true)
	public void atualizaAtivacao(String ativacao, Long id, Long maquinaId);

}
