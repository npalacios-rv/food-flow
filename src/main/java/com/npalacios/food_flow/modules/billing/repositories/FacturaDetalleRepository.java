package com.npalacios.food_flow.modules.billing.repositories;

import com.npalacios.food_flow.modules.billing.entities.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Integer> {
}
