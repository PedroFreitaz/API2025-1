package org.serratec.backend.endity;

public class Aluno {
	private Long matricula;
	String nome;
	String email;

	public Aluno(Long matricula, String nome, String email) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email=" + email + "]";
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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

}
