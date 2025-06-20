package org.serratec.backend.enums;

import org.serratec.backend.exception.EnumExeption;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
	SUV,HATCH,PICAPE,SEDAN,CONVERSIVEL,COUPE;
	
	@JsonCreator
	public static Categoria verificarCategoria(String valor) {
		for (Categoria categoria : Categoria.values()) {
			if (valor.equals(categoria.name())) {
				return categoria;
			}
		}
		throw new EnumExeption("Categoria de carro inválida");
	}
	

}
