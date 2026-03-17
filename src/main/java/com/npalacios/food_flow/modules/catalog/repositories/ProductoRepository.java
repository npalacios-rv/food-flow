package com.npalacios.food_flow.modules.catalog.repositories;

import com.npalacios.food_flow.modules.catalog.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
