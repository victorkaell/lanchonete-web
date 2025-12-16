package io.github.victorkaell.lanchonete.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome não pode estar vazio.")
	@Size(min = 3, max = 100, message = "O nome precisa ter entre 3 e 100 caracteres.")
	private String nome;
	
	@NotBlank(message = "A senha é obrigatória.")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
	private String senha;
	
	@NotBlank(message = "O cargo não pode estar vazio.")
	private String cargo;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.cargo == null) {
	        return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
	    }
		
		return List.of(new SimpleGrantedAuthority("ROLE_" + this.cargo.toUpperCase()));
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.nome;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", cargo=" + cargo + "]";
	}
}
