package com.npalacios.food_flow.modules.catalog.repositories;

import com.npalacios.food_flow.modules.catalog.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
