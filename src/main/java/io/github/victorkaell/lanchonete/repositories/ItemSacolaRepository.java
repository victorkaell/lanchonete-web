package io.github.victorkaell.lanchonete.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.victorkaell.lanchonete.models.ItemSacola;
import io.github.victorkaell.lanchonete.models.Produto;
import io.github.victorkaell.lanchonete.models.Usuario;

public interface ItemSacolaRepository extends JpaRepository<ItemSacola, Long>{
	List<ItemSacola> findByUsuario(Usuario usuario);
	ItemSacola findByUsuarioAndProduto(Usuario usuario, Produto produto);
}
