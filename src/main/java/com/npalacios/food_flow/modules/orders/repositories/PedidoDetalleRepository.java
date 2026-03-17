package com.npalacios.food_flow.modules.orders.repositories;

import com.npalacios.food_flow.modules.orders.entities.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Integer> {
}
