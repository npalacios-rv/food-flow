package com.npalacios.food_flow.modules.orders.controllers;

import com.npalacios.food_flow.modules.orders.entities.Pedido;
import com.npalacios.food_flow.modules.orders.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private final PedidoService service;

    @GetMapping
    public List<Pedido> getAll() {
        return service.findAll();
    }
}
