package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Compra;
import com.gft.casadeeventos.repository.compras;

@Controller
@RequestMapping("/historico")
public class controllerhistorico {
	
	@Autowired
	private compras compra;
	
	@RequestMapping
	public ModelAndView pesquisaevento() {		
		List<Compra> compras =  compra.findAll();
		ModelAndView mv = new ModelAndView("historico");
		mv.addObject(new Compra());
		mv.addObject("compras", compras);
		return mv;
	}
	
	

}
