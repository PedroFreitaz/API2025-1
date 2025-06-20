package org.serratec.backend.revisao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {

	@GetMapping
	public String teste(@RequestParam String nome) {
		return nome.toUpperCase();
	}

	@GetMapping("/teste2")
	public Integer soma(@RequestParam Integer num1, @RequestParam Integer num2) {
		return num1 + num2;
	}

	@GetMapping("/teste")
	public String teste2() {
		return "Java";
	}

}
