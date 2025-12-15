package io.github.victorkaell.lanchonete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.github.victorkaell.lanchonete.models.Usuario;
import io.github.victorkaell.lanchonete.repositories.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String formularioLogin(Usuario usuario) {
		return "login";
	}
	
	@GetMapping("/cadastro")
	public String formularioCadastro(Usuario usuario) {
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String cadastrarUsuario(Usuario usuario) {
		String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
		
		usuario.setSenha(senhaCriptografada);
		
		ur.save(usuario);
		return "redirect:/login";
	}
}
