package io.github.victorkaell.lanchonete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.victorkaell.lanchonete.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByNome(String nome);
}
