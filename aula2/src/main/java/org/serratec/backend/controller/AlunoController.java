package org.serratec.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.endity.Aluno;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	private static List<Aluno> alunos = new ArrayList();

	static {
		alunos.add(new Aluno(123L, "Adriano", "adrianbho@gmail.com"));
		alunos.add(new Aluno(321L, "Joana", "joana@gmail.com"));
		alunos.add(new Aluno(456L, "Fernando", "Fernandoo@gmail.com"));
		alunos.add(new Aluno(654L, "ACrias", "Cris@gmail.com"));
	}

	@GetMapping
	public List<Aluno> listar() {
		return alunos;
	}

	@GetMapping("/{matricula}")
	public Aluno buscar(@PathVariable Long matricula) {

		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}

	@PostMapping
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}

	@PostMapping("/varios")
	public List<Aluno> inserirVarios(@RequestBody List<Aluno> alunosNovos) {
		alunos.addAll(alunosNovos);
		return alunosNovos;

	}

	@DeleteMapping("/{matricula}")
	public void apagar(@PathVariable Long matricula) {

		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				alunos.remove(aluno);
				break;
			}
		}
	}

	@PutMapping("/{matricula}")
	public Aluno atualizar(@PathVariable Long matricula, @RequestBody Aluno aluno) {
		for (Aluno a : alunos) {
			if (a.getMatricula().equals(matricula)) {
				aluno.setMatricula(matricula);
				alunos.set(alunos.indexOf(a), aluno);
				return aluno;
			}
		}
		return null;
	}

}
