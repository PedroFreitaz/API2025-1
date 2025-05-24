package org.serratec.backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Gerente extends Funcionario{
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
