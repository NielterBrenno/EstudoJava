package br.com.oauth2.exemplo.service;

import br.com.oauth2.exemplo.domain.Usuario;
import br.com.oauth2.exemplo.domain.exception.UsuarioException;
import br.com.oauth2.exemplo.repository.UsuarioRepository;

public interface UsuarioService extends PersistenceService<Usuario, Long, UsuarioException, UsuarioRepository> {

}
