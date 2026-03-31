package com.npalacios.food_flow.modules.orders.controllers;

import com.npalacios.food_flow.modules.dto.StandardResponse;
import com.npalacios.food_flow.modules.orders.dto.OrderDto;
import com.npalacios.food_flow.modules.orders.services.GestionPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orders/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final GestionPedidoService gestionPedidoService;

    @GetMapping
    public ResponseEntity<StandardResponse> getAll() {
        return ResponseEntity.ok(gestionPedidoService.getAllPedidos());
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createOrder(@Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(gestionPedidoService.createOrder(orderDto));
    }
}
