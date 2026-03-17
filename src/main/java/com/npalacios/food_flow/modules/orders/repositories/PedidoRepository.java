package com.npalacios.food_flow.modules.orders.repositories;

import com.npalacios.food_flow.modules.orders.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
