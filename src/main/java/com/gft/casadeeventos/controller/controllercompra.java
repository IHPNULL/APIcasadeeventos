package com.gft.casadeeventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.casadeeventos.model.Compra;
import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.compras;
import com.gft.casadeeventos.repository.eventos;

@Controller
@RequestMapping("/compra")
public class controllercompra {
	
	@Autowired
	private compras comps;
	
	@Autowired
	private eventos event;
		
	@RequestMapping(value ="/{id}", method= RequestMethod.GET)
	public ModelAndView tela(@PathVariable Long id) {
		Evento todosEventos = event.findById(id).get();
		ModelAndView mv = new ModelAndView("compra");
		mv.addObject("eventos", todosEventos);
		mv.addObject(new Evento());
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ModelAndView fim(@PathVariable("id") Long id, RedirectAttributes atributes,int ning)
	{
		Evento todosEventos = event.findById(id).get();
		ModelAndView mv = new ModelAndView("redirect:/home");
		
		if (todosEventos.getIngressosd()-ning >= 0)
		{
			Compra comp = new Compra(todosEventos.getId(),todosEventos.getNome(),(todosEventos.getPreco()*ning), todosEventos.getData(),ning);
			comps.save(comp);				
		
			todosEventos.setIngressosd(todosEventos.getIngressosd() - ning);
			mv.addObject(todosEventos.getIngressosd());
			event.save(todosEventos);			
		}
		else 
		{
			atributes.addFlashAttribute("mensagem", "Fim");
		}
		System.out.println(ning);
		return mv;
	}	
}