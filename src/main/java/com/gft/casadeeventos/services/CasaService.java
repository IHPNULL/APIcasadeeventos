package com.gft.casadeeventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gft.casadeeventos.model.Casa;
import com.gft.casadeeventos.repository.casas;
import com.gft.casadeeventos.services.exceptions.CasaExistenteException;
import com.gft.casadeeventos.services.exceptions.CasaNaoEncontradaException;

@Service
public class CasaService {

	@Autowired
	private casas casaa;

	public List<Casa> listar() {
		return casaa.findAll();
	}

	public Casa salvar(Casa casa) {
		if (casa.getId() != null) {
			Optional<Casa> a = casaa.findById(casa.getId());
			if (a.isPresent()==false) {
				throw new CasaExistenteException("Casa já existe!");
			}
		}
		return casaa.save(casa);
	}

	public Optional<Casa> buscar(Long id) {
		Optional<Casa> casa = casaa.findById(id);

		if (casa.isPresent()==false) {
			throw new CasaNaoEncontradaException("A casa não pode ser encontrado!");
		}
		return casa;
	}

	public void deletar(Long ID) {
		try {
			casaa.deleteById(ID);
		} catch (EmptyResultDataAccessException e) {
			throw new CasaNaoEncontradaException("A casa não foi encontrada!");
		}
	}

	public void atualizar(Casa casa) {
		verificarExistencia(casa);
		casaa.save(casa);
	}

	private void verificarExistencia(Casa casa) {
		buscar(casa.getId());
	}

	public List<Casa> listarOrdem() {
		return casaa.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public List<Casa> listarOrdemDec() {
		return casaa.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}

	public Casa buscarNome(String end) {
		Casa casa = casaa.findByEnd(end);

		if (casa == null) {
			throw new CasaNaoEncontradaException("A casa não pode ser encontrado!");
		}

		return casa;
	}

}