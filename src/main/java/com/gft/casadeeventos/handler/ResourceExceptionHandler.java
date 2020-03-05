package com.gft.casadeeventos.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gft.casadeeventos.model.ResourceError;
import com.gft.casadeeventos.services.exceptions.CasaNaoEncontradaException;
import com.gft.casadeeventos.services.exceptions.EventoExistenteException;
import com.gft.casadeeventos.services.exceptions.EventoNaoEncontradoException;
import com.gft.casadeeventos.services.exceptions.MensagemErroException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(CasaNaoEncontradaException.class)
	public ResponseEntity<ResourceError> handleCasaNaoEncontradaException(CasaNaoEncontradaException e,
			HttpServletRequest request) {

		ResourceError erro = new ResourceError();
		erro.setStatus(404l);
		erro.setTitulo("Casa não pode ser encontrada!");
		erro.setAjuda("http://erros.casa.com/404");
		erro.setData(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(EventoExistenteException.class)
	public ResponseEntity<ResourceError> handleEventoExistenteException(EventoExistenteException e,
			HttpServletRequest request) {
		ResourceError erro = new ResourceError();
		erro.setStatus(404l);
		erro.setTitulo("O evento já existe!");
		erro.setAjuda("http://erros.evento.com/404");
		erro.setData(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity<ResourceError> handleEventoNaoEncontradoException(EventoNaoEncontradoException e,
			HttpServletRequest request) {
		ResourceError erro = new ResourceError();
		erro.setStatus(404l);
		erro.setTitulo("O evento não existe!");
		erro.setAjuda("http://erros.casa.com/404");
		erro.setData(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ResourceError> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {
		ResourceError erro = new ResourceError();
		erro.setStatus(404l);
		erro.setTitulo("Requisição inválida.");
		erro.setAjuda("http://erros.casa.com/400");
		erro.setData(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(MensagemErroException.class)
	public ResponseEntity<ResourceError> handleMensagemErroException(MensagemErroException e,
			HttpServletRequest request) {

		ResourceError erro = new ResourceError();
		erro.setStatus(500l);
		erro.setTitulo("Faltou algum dado para preencher.");
		erro.setAjuda("http://erros.casa.com/500");
		erro.setData(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}
}
