package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.entity.Produto;
import org.serratec.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir(@RequestBody Produto produto) {
		return repository.save(produto);

	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> inserir(@RequestBody List<Produto> produtos) {
		return repository.saveAll(produtos);

	}

	@GetMapping
	public List<Produto> listar() {
		return repository.findAll();
	}

	@GetMapping
	public Produto listarPorId(@PathVariable Long id) {
		return repository.findById(id).get();
	}
}
