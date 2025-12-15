package io.github.victorkaell.lanchonete.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import io.github.victorkaell.lanchonete.models.ItemSacola;
import io.github.victorkaell.lanchonete.models.Produto;
import io.github.victorkaell.lanchonete.models.Usuario;
import io.github.victorkaell.lanchonete.repositories.ItemSacolaRepository;
import io.github.victorkaell.lanchonete.repositories.ProdutoRepository;

@Controller
public class SacolaController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@Autowired
	private ItemSacolaRepository isr;;
	
	@GetMapping("/sacola")
	public ModelAndView verSacola(@AuthenticationPrincipal Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		
		List<ItemSacola> itens = isr.findByUsuario(usuario);
		
		Double total = 0.0;
		for (int i = 0; i < itens.size(); i++) {
			ItemSacola item = itens.get(i);
			
			Double subtotal = item.getSubtotal();
			
			total += subtotal;
		}
		
		mv.setViewName("sacola");
		mv.addObject("itens", itens);
		mv.addObject("total", total);
		
		return mv;
	}
	
	@GetMapping("/sacola/{idProduto}/adicionar")
    public String adicionarProduto(@PathVariable Long idProduto, @AuthenticationPrincipal Usuario usuario) {

        Optional<Produto> opt = pr.findById(idProduto);
        
        if (opt.isEmpty()) { 	
        	return "redirect:/home";
        }
        
        Produto produto = opt.get();
        
        System.out.println("Produto a ser adicionado: " + produto);
        
        if (produto != null) {
            
            ItemSacola item = isr.findByUsuarioAndProduto(usuario, produto);
            
            if (item != null) {
                item.setQuantidade(item.getQuantidade() + 1);
                isr.save(item);
                
                System.out.println("Item: " + item);
            } else {
                ItemSacola novoItem = new ItemSacola(produto, usuario, 1);
                isr.save(novoItem);
                
                System.out.println("Novo item: " + novoItem);
            }
        }
        
        return "redirect:/sacola";
    }
	
	@GetMapping("/sacola/item/{idItem}/adicionar")
    public String adicionarItem(@PathVariable Long idItem) {
        
        Optional<ItemSacola> opt = isr.findById(idItem);
        
        if (opt.isEmpty()) { 	
        	return "redirect:/home";
        }
        
        ItemSacola item = opt.get();
        
        System.out.println("Item a ser adicionado: " + item);
        
        item.setQuantidade(item.getQuantidade() + 1);
        
        isr.save(item);
        
        return "redirect:/sacola";
    }
	
	@GetMapping("/sacola/item/{idItem}/remover")
    public String removerItem(@PathVariable Long idItem) {

        Optional<ItemSacola> opt = isr.findById(idItem);
        
        if (opt.isEmpty()) {
        	return "redirect:/home";
        }
        
        ItemSacola item = opt.get();
        
        System.out.println("Item a ser diminuído: " + item);
        
        if (item.getQuantidade() <= 1) {
        	isr.delete(item);
        } else {
        	item.setQuantidade(item.getQuantidade() - 1);
        	isr.save(item);
        }
        
        return "redirect:/sacola";
    }
}
