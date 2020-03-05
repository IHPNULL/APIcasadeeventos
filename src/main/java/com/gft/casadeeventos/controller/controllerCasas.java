package com.gft.casadeeventos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.casadeeventos.model.Casa;
import com.gft.casadeeventos.repository.casas;

@Controller
@RequestMapping("/casadeshow")
public class controllerCasas {

	@Autowired
	private casas cas;

	@RequestMapping
	public ModelAndView pesquisacasa() {
		List<Casa> casas = cas.findAll();
		ModelAndView mv = new ModelAndView("Casas");
		mv.addObject(new Casa());
		mv.addObject("casaaas", casas);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Casa casaa, Errors errors) {
		ModelAndView mv = new ModelAndView("Casas");

		if (errors.hasErrors()) {
			return mv;
		}

		casaa.setCapa(casaa.getCapa());

		cas.save(casaa);

		mv.addObject(new Casa());
		List<Casa> todasCasas = cas.findAll();
		mv.addObject("casaaas", todasCasas);
		mv.addObject("mensagem", "Casa cadastrada com sucesso!!");
		return mv;
	}

	@RequestMapping("/editar/{id}")
	public ModelAndView edicao(@PathVariable("id") Casa casaaa) {
		List<Casa> casas = cas.findAll();
		ModelAndView mv = new ModelAndView("CasasEdit");
		mv.addObject(casaaa);
		mv.addObject("casaaas", casas);
		return mv;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable Long id) {
		cas.deleteById(id);
		return "redirect:/casadeshow";
	}
}