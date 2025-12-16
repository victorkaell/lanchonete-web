package io.github.victorkaell.lanchonete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.victorkaell.lanchonete.models.ItemSacola;
import io.github.victorkaell.lanchonete.repositories.ItemSacolaRepository;

@Controller
public class CozinhaController {
	
	@Autowired
	private ItemSacolaRepository isr;
	
	@GetMapping("/cozinha/pedidos")
	public ModelAndView visualizarPedidos() {
		ModelAndView mv = new ModelAndView();
		
		List<ItemSacola> itens = isr.findAll();
		
		mv.setViewName("cozinha/fila");
		mv.addObject("itens", itens);
		
		return mv;
	}
}
