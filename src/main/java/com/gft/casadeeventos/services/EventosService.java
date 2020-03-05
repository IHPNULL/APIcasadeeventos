package com.gft.casadeeventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.eventos;
import com.gft.casadeeventos.services.exceptions.CasaNaoEncontradaException;
import com.gft.casadeeventos.services.exceptions.EventoExistenteException;
import com.gft.casadeeventos.services.exceptions.EventoNaoEncontradoException;

@Service
public class EventosService {

	@Autowired
	private eventos envents;

	public List<Evento> listar() {
		return envents.findAll();
	}

	public Evento salvar(Evento evento) {
		if (evento.getId() != null) {
			Optional<Evento> a = envents.findById(evento.getId());
			if (a.isPresent()) {
				throw new EventoExistenteException("Evento já existe!");
			}
		}
		return envents.save(evento);
	}

	public Evento buscar(Long codigo) {

		Evento evento = envents.findById(codigo).get();

		if (evento == null) {
			throw new EventoNaoEncontradoException("O evento não pode ser encontrado!");
		}
		return evento;
	}

	public void deletar(Long codigo) {
		try {
			envents.deleteById(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new CasaNaoEncontradaException("A casa não foi encontrada!");
		}
	}

	public void atualizar(Evento evento) {
		verificarExistencia(evento);
		envents.save(evento);
	}

	private void verificarExistencia(Evento evento) {
		buscar(evento.getId());
	}

	public List<Evento> listarNomeAsc() {
		return envents.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public List<Evento> listarNmeDesc() {
		return envents.findAll(Sort.by(Sort.Direction.DESC, "nome"));
	}

	public List<Evento> listarCapacidadeAsc() {
		return envents.findAll(Sort.by(Sort.Direction.ASC, "ingressos"));
	}

	public List<Evento> listarCapacidadeDesc() {
		return envents.findAll(Sort.by(Sort.Direction.DESC, "ingressos"));
	}

	public List<Evento> listarDataAsc() {
		return envents.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}

	public List<Evento> listarDataDesc() {
		return envents.findAll(Sort.by(Sort.Direction.DESC, "data"));
	}

	public List<Evento> listarPrecoAsc() {
		return envents.findAll(Sort.by(Sort.Direction.ASC, "preco"));
	}

	public List<Evento> listarPrecoDesc() {
		return envents.findAll(Sort.by(Sort.Direction.DESC, "preco"));
	}

}
