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

import com.gft.casadeeventos.model.Compra;
import com.gft.casadeeventos.services.CompraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Vendas")
@RestController
@RequestMapping("/api/vendas")
public class CompraResource {
	
	@Autowired
	private CompraService compraServ;
	
	@ApiOperation(value="Lista de eventos comprados.")
	@RequestMapping(method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Compra>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(compraServ.buscarHistorico());
	}
	
	@ApiOperation(value="Buscar um evento específico.")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compra> buscar(@ApiParam(value = "Buscar um evento", example = "1")@PathVariable("id") Long id){
		Compra compra = compraServ.buscarEspecifico(id);
		return ResponseEntity.status(HttpStatus.OK).body(compra);
	}

}
