package io.github.victorkaell.lanchonete.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.victorkaell.lanchonete.models.Adicional;
import io.github.victorkaell.lanchonete.models.Produto;

public interface AdicionalRepository extends JpaRepository<Adicional, Long> {
	List<Adicional> findByProduto(Produto produto);
}
