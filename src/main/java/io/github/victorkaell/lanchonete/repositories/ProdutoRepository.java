package io.github.victorkaell.lanchonete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.victorkaell.lanchonete.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
