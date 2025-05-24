package org.serratec.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VendedorEmpresa extends Vendedor {

	private Integer numeroCarteiraTrabalho;
	
	private LocalDate dataAdimissao;

	public Integer getNumeroCarteiraTrabalho() {
		return numeroCarteiraTrabalho;
	}

	public void setNumeroCarteiraTrabalho(Integer numeroCarteiraTrabalho) {
		this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
	}

	public LocalDate getDataAdimissao() {
		return dataAdimissao;
	}

	public void setDataAdimissao(LocalDate dataAdimissao) {
		this.dataAdimissao = dataAdimissao;
	}

	
}
