package io.github.victorkaell.lanchonete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.victorkaell.lanchonete.models.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
