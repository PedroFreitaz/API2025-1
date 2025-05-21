package org.serratec.backend.enums;


import org.serratec.backend.exception.EnumExeption;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Estado {
	
	AC, AL, AP, AM, BA, CE, DF, ES, GO, MA,
    MT, MS, MG, PA, PB, PR, PE, PI, RJ, RN,
    RS, RO, RR, SC, SP, SE, TO;

    @JsonCreator
	public static Estado verificarEstado(String valor) {
		for (Estado estado : Estado.values()) {
			if (valor.equals(estado.name())) {
				return estado;
			}
		}
		throw new EnumExeption("Estado de carro inválida");
	}
}
