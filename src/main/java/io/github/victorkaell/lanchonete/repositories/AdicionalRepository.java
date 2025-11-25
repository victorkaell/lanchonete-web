package io.github.victorkaell.lanchonete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.victorkaell.lanchonete.models.Adicional;

public interface AdicionalRepository extends JpaRepository<Adicional, Long> {
	
}
