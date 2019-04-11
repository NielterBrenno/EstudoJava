package br.com.oauth2.test;

import org.junit.Test;

import br.com.oauth2.exemplo.domain.Usuario;

public class UsuarioTest {

	@Test
	public void getPasswordCryptEncoder() {
		Usuario usuario = new Usuario();
		usuario.setPassword("123456");
		String hash = usuario.getPasswordBcryptEncoder();
		System.out.println(hash);
	}

}

