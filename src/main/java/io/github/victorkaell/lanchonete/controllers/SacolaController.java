package io.github.victorkaell.lanchonete.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.victorkaell.lanchonete.models.ItemSacola;
import io.github.victorkaell.lanchonete.models.Produto;
import io.github.victorkaell.lanchonete.models.Usuario;
import io.github.victorkaell.lanchonete.repositories.ItemSacolaRepository;
import io.github.victorkaell.lanchonete.repositories.ProdutoRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class SacolaController {
	
	@Autowired
	private ProdutoRepository pr;
	
	@Autowired
	private ItemSacolaRepository isr;;
	
	@GetMapping("/sacola")
	public ModelAndView verSacola(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if (usuario == null) {
			mv.setViewName("redirect:/login");
			return mv;
		}
		
		List<ItemSacola> itens = isr.findByUsuario(usuario);
		
		mv.setViewName("sacola");
		mv.addObject("itens", itens);
		
		return mv;
	}
	
	@PostMapping("/sacola/adicionar/{id}")
    public String adicionar(@PathVariable Long id, HttpSession session) {
		
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }

        Optional<Produto> opt = pr.findById(id);
        
        if (opt.isEmpty()) {
        	return "redirect:/";
        }
        
        Produto produto = opt.get();
        
        if (produto != null) {
            
            ItemSacola item = isr.findByUsuarioAndProduto(usuario, produto);
            
            if (item != null) {
                item.setQuantidade(item.getQuantidade() + 1);
                isr.save(item);
            } else {
                ItemSacola novoItem = new ItemSacola(produto, usuario, 1);
                isr.save(novoItem);
            }
        }
        
        return "redirect:/sacola";
    }
}
