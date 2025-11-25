package io.github.victorkaell.lanchonete.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/produtos/adicionar")
	public String formularioAdmin() {
		return "admin/formProduto";
	}
}
