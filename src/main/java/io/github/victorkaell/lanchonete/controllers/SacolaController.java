package io.github.victorkaell.lanchonete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.victorkaell.lanchonete.models.Adicional;
import io.github.victorkaell.lanchonete.models.Produto;
import io.github.victorkaell.lanchonete.repositories.AdicionalRepository;
import io.github.victorkaell.lanchonete.repositories.ProdutoRepository;

@Controller
public class SacolaController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@Autowired
	private AdicionalRepository ar;
	
	@GetMapping("/sacola")
	public ModelAndView verSacola() {
		ModelAndView mv = new ModelAndView();
		
		List<Produto> produtos = pr.findAll();
		List<Adicional> adicionais = ar.findAll();
		
		mv.setViewName("sacola");
		mv.addObject("produtos", produtos);
		mv.addObject("adicionais", adicionais);
		
		return mv;
	}
}
