package io.github.victorkaell.lanchonete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.victorkaell.lanchonete.models.Produto;
import io.github.victorkaell.lanchonete.repositories.ProdutoRepository;

@Controller
public class MenuController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@GetMapping("/")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView();
		
		List<Produto> produtos = pr.findAll();
		
		mv.addObject("produtos", produtos);
		
		mv.setViewName("home");
		
		return mv;
	}
}
