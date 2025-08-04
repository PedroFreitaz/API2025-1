package org.serratec.backend.service;

import java.util.Optional;

import org.serratec.backend.entity.ClientePerfil;
import org.serratec.backend.repository.ClientePerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientePerfilService {
	@Autowired
	private ClientePerfilRepository repository;

	public ClientePerfil buscar(Long id) {
		Optional<ClientePerfil> perfil = repository.findById(id);
		return perfil.get();
	}
}