package com.gft.casadeeventos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft.casadeeventos.model.Usuario;
import com.gft.casadeeventos.services.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Usuarios")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usu;
	
	@ApiOperation(value="Lista de Usuarios.")
	@RequestMapping(method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Usuario>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(usu.buscarHistorico());
	}
	
	@ApiOperation(value="Buscar um usuario específico.")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@ApiParam(value = "Buscar um usuario", example = "1")@PathVariable("id") Long id){
		Usuario user = usu.buscarEspecifico(id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
