package io.github.victorkaell.lanchonete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.github.victorkaell.lanchonete.models.Usuario;
import io.github.victorkaell.lanchonete.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/login")
	public String formularioLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String salvarLogin(String nome, String senha, HttpSession session) {
		Usuario usuario = ur.findByNomeAndSenha(nome, senha);
		
		if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/";
        } else {
            return "redirect:/login?erro=true";
        }
	}
	
	@GetMapping("/logout")
    public String deslogar(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
