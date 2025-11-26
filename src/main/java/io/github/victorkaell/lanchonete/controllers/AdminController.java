package io.github.victorkaell.lanchonete.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.victorkaell.lanchonete.models.Produto;
import io.github.victorkaell.lanchonete.repositories.ProdutoRepository;

@Controller
public class AdminController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@GetMapping("/admin/produtos/adicionar")
	public String formularioAdmin(Produto produto) {
		return "admin/formProduto";
	}
	
	@PostMapping("/admin/produtos/adicionar")
	public String adicionarProduto(Produto produto) {
		System.out.println(produto);
		
		pr.save(produto);
		
		return "redirect:/";
	}
	
	@GetMapping("/admin/produtos/{idProduto}/editar")
	public ModelAndView editarProduto(@PathVariable Long idProduto) {
		ModelAndView mv = new ModelAndView();
		
		Optional<Produto> opt = pr.findById(idProduto);
		
		if (opt.isEmpty()) {
			mv.setViewName("redirect:/");
			
			return mv;
		}
		
		Produto produto = opt.get();
		
		mv.addObject("produto", produto);
		mv.setViewName("admin/formProduto");
		
		return mv;
	}
	
	@GetMapping("/admin/produtos/{idProduto}/apagar")
	public ModelAndView apagarProduto(@PathVariable Long idProduto) {
		ModelAndView mv = new ModelAndView();
		
		Optional<Produto> opt = pr.findById(idProduto);
		
		if (opt.isEmpty()) {
			mv.setViewName("redirect:/");
			
			return mv;
		}
		
		Produto produto = opt.get();
		
		pr.delete(produto);
		
		mv.setViewName("redirect:/");
		
		return mv;
	}
}
