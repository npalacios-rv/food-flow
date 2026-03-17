package com.npalacios.food_flow.modules.billing.controllers;

import com.npalacios.food_flow.modules.billing.entities.MetodoPago;
import com.npalacios.food_flow.modules.billing.services.MetodoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/billing/metodos-pago")
@RequiredArgsConstructor
public class MetodoPagoController {

    @Autowired
    private final MetodoPagoService service;

    @GetMapping
    public List<MetodoPago> getAll() {
        return service.findAll();
    }
}
