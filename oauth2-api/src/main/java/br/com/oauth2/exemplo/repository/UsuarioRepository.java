package br.com.oauth2.exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.oauth2.exemplo.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from Usuario u join fetch u.perfis where u.username = :username")
	Usuario findOneByUsername(@Param("username") String username);

}
