package br.com.oauth2.exemplo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Table(name = "tb_perfil")
@Data
public class Perfil implements GrantedAuthority {

	private static final long serialVersionUID = -4851463660806294042L;

	public static final Perfil ADMIN = new Perfil("ROLE_ADMIN");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	private Integer id;
	@Column(unique = true)
	private String nome;

	public Perfil() {
	}

	public Perfil(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return nome;
	}

}
