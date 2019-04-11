package br.com.oauth2.exemplo.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario implements UserDetails, Serializable {

	private static final long serialVersionUID = 6017507807890100175L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "IdGenerator")
	@SequenceGenerator(initialValue = 1, name = "IdGenerator")
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "login")
	private String username;

	@Column(name = "senha")
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_usuario_tb_perfil", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
	private Set<Perfil> perfis = new HashSet<>();

	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		this();
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	public String getPasswordBcryptEncoder() {
		return new BCryptPasswordEncoder().encode(password);
	}

	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}

}

