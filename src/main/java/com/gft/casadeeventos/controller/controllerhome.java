package com.gft.casadeeventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Evento;
import com.gft.casadeeventos.repository.eventos;

@Controller
@RequestMapping
public class controllerhome {

		@Autowired
		private eventos event;
	
		@RequestMapping("/home")
		public ModelAndView home()
		{
			List<Evento> eventos =  event.findAll();
			ModelAndView mv = new ModelAndView("Home");
			mv.addObject("eventos", eventos);
			
			return mv;
		}
	

}
