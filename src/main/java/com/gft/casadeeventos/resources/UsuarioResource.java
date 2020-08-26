package com.gft.casadeeventos.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@ApiOperation(value = "Listar usuarios.")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(usu.listarUsu());
	}

	@ApiOperation(value = "Buscar um usuario específico.")
	@GetMapping(value = "/{ID}")
	public ResponseEntity<Optional<Usuario>> buscar(
			@ApiParam(value = "Buscar um usuario específico.", example = "1") @PathVariable("ID") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(usu.buscarUsuario(id));
	}

	@ApiOperation(value = "Deletar um Usuario")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(
			@ApiParam(name = "Deletar um Usuario.", value = "Deletar um Usuario da lista.") @PathVariable("id") Long id) {
		usu.deletar(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
	@ApiOperation(value = "Salvar um usuario.")
	@PostMapping("/novo")
	public ModelAndView salvarUsuario(Usuario users) {
		ModelAndView mv = new ModelAndView("redirect:/login");
		usu.salvar(users.getId());
		return mv;
	}

}
