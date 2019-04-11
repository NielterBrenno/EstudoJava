package br.com.oauth2.exemplo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.oauth2.exemplo.repository.UsuarioRepository;
import br.com.oauth2.exemplo.service.UsuarioService;

@Service
public class UsuarioManager implements UsuarioService , UserDetailsService{

    @Autowired
    private UsuarioRepository repository;
	
	@Override
	public UsuarioRepository getDAO() {
		return repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getDAO().findOneByUsername(username);
	}
	
}