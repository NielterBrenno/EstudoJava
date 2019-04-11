package br.com.oauth2.exemplo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oauth2.exemplo.domain.exception.UsuarioException;
import br.com.oauth2.exemplo.dto.UsuarioDTO;
import br.com.oauth2.exemplo.service.UsuarioService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "/usuario", description = "Usuario", produces = "application/json")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	/*
	 *  Api privada que retorna todos os usuários cadastrados, 
	 *  Esse endpoint requer autenticação Oauth2
	 */
	@GetMapping("/private/usuario/all")
	public ResponseEntity<List<UsuarioDTO>> getAllNames() {
		List<UsuarioDTO> usuarios = new ArrayList<>();
		try {
			usuarioService.findAll().forEach(u -> {
			final UsuarioDTO dto = new UsuarioDTO();
				dto.setNome(u.getNome());
				dto.setUserName(u.getUsername());
				usuarios.add(dto);
			});
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.OK);
	}

	/*
	 *  Api publica sem a necessidade de autenticação
	 */
	@GetMapping("/public/usuario/userNames")
	public ResponseEntity<List<String>> getAllLogins() {
		List<String> userNames = new ArrayList<>();
		try {
			usuarioService.findAll().forEach(u -> { userNames.add(u.getUsername()); });
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<String>>(userNames, HttpStatus.OK);
	}

}
