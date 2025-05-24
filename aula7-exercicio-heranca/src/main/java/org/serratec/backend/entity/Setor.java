package org.serratec.backend.entity;

import org.serratec.backend.enums.SetorEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Setor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private SetorEnum nome;
	

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SetorEnum getNome() {
		return nome;
	}

	public void setNome(SetorEnum nome) {
		this.nome = nome;
	}
	
	
}
