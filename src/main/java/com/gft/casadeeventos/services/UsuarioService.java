package com.gft.casadeeventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.casadeeventos.model.Usuario;
import com.gft.casadeeventos.repository.usuarios;
import com.gft.casadeeventos.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioService {

	@Autowired
	private usuarios usus;
	
	public List<Usuario> buscarHistorico() {
		return usus.findAll();
	}
	
	public Usuario buscarEspecifico(Long id) {
		Usuario comp = usus.findById(id).get();

			if (comp == null) {
				throw new UsuarioNaoEncontradoException("O usuario não pode ser encontrado!");
			}
			return comp;
	}
}
