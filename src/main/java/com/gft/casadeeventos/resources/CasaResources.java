package com.gft.casadeeventos.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft.casadeeventos.model.Casa;
import com.gft.casadeeventos.services.CasaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Casas")
@RestController
@RequestMapping("/api/casas")
public class CasaResources {

	@Autowired
	private CasaService casaServ;

	@ApiOperation(value = "Lista das casas.")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Casa>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(casaServ.listar());
	}

	@ApiOperation(value = "Salvar novas casas.")
	@PostMapping()
	public ResponseEntity<Void> salvar(
			@ApiParam(name = "Adicionar uma casa.", value = "Adicionar uma casa a lista") @Valid @RequestBody Casa casa) {
		casa = casaServ.salvar(casa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ID}").buildAndExpand(casa.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Buscar um casa específica.")
	@GetMapping(value = "/{ID}")
	public ResponseEntity<Optional<Casa>> buscar(
			@ApiParam(value = "Buscar uma casa", example = "1") @PathVariable("ID") Long ID) {
		Optional<Casa> casa = casaServ.buscar(ID);
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}

	@ApiOperation(value = "Deletar um casa")
	@DeleteMapping(value = "/{ID}")
	public ResponseEntity<Void> deletar(
			@ApiParam(name = "Deletar uma casa.", value = "Deletar uma casa da lista.") @PathVariable("ID") Long ID) {
		casaServ.deletar(ID);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@ApiOperation(value = "Atualizar um dado de uma casa.")
	@PutMapping(value = "/{ID}")
	public ResponseEntity<Void> atualizar(
			@ApiParam(name = "Atualizar uma casa.", value = "Atualizar dados de uma casa.", example = "1") @RequestBody Casa casa,
			@PathVariable("ID") Long ID) {
		casa.setId(ID);
		casaServ.atualizar(casa);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@ApiOperation(value = "Colocar em ordem alfabética ascendente.")
	@GetMapping("/asc")
	public ResponseEntity<List<Casa>> ordemAsc() {
		return ResponseEntity.status(HttpStatus.OK).body(casaServ.listarOrdem());
	}

	@ApiOperation(value = "Colocar em ordem alfabética descendente.")
	@GetMapping("/desc")
	public ResponseEntity<List<Casa>> ordemDesc() {
		return ResponseEntity.status(HttpStatus.OK).body(casaServ.listarOrdemDec());
	}

	@ApiOperation(value = "Buscar por nome.")
	@GetMapping("/nome/{end}")
	public ResponseEntity<Casa> buscarNome(
			@ApiParam(value = "Buscar uma casa por nome.") @PathVariable("end") String end) {
		Casa casa = casaServ.buscarNome(end);
		return ResponseEntity.status(HttpStatus.OK).body(casa);
	}
}
