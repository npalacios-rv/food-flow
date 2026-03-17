package com.npalacios.food_flow.modules.orders.controllers;

import com.npalacios.food_flow.modules.orders.entities.PedidoDetalle;
import com.npalacios.food_flow.modules.orders.services.PedidoDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/pedido-detalles")
@RequiredArgsConstructor
public class PedidoDetalleController {

    @Autowired
    private final PedidoDetalleService service;

    @GetMapping
    public List<PedidoDetalle> getAll() {
        return service.findAll();
    }
}
