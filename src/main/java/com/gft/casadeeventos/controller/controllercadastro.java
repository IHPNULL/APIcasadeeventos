package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Usuario;
import com.gft.casadeeventos.repository.usuarios;

@Controller
@RequestMapping("/Usuarios")
public class controllercadastro {
	
	
	@Autowired
	private usuarios user;
	
	@RequestMapping
	public ModelAndView pesquisausuario() {
		List<Usuario> eventos =  user.findAll();
		ModelAndView mv = new ModelAndView("Usuarios");
		mv.addObject("CadastroUsuario", eventos);
		return mv;
	}
	
	@RequestMapping(value = "/novo",method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Usuario User, Errors errors) {	
		ModelAndView mv = new ModelAndView("CadastroUsuario");

		
		if(errors.hasErrors()) {
			return mv;
			
		}
		
		mv.addObject(new Usuario());
		
		user.save(User);
		
		mv.addObject("mensagem", "cadastrado com sucesso");
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroUsuario");
		mv.addObject(new Usuario());
		return mv;
	}

}
