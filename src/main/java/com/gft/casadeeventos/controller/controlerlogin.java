package com.gft.casadeeventos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class controlerlogin {
	
	@RequestMapping
	public ModelAndView login()	{
		ModelAndView mv = new ModelAndView("Login");
		
		return mv;
	}
}
