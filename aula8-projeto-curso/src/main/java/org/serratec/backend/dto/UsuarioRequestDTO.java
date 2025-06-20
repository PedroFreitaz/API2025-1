package org.serratec.backend.dto;

import java.util.HashSet;
import java.util.Set;

import org.serratec.backend.entity.Usuario;
import org.serratec.backend.entity.UsuarioPerfil;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {
	@NotBlank
	private String nome;

	@Email
	private String email;

	@NotBlank
	private String senha;
	
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();
	
	
	
	public Set<UsuarioPerfil> getUsuarioPerfis() {
		return usuarioPerfis;
	}

	public UsuarioRequestDTO() {
		
	}

	public UsuarioRequestDTO(Usuario usuario) {
		
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
