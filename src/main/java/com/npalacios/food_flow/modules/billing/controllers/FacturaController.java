package com.npalacios.food_flow.modules.billing.controllers;

import com.npalacios.food_flow.modules.billing.entities.Factura;
import com.npalacios.food_flow.modules.billing.services.FacturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/billing/facturas")
@RequiredArgsConstructor
public class FacturaController {

    @Autowired
    private final FacturaService service;

    @GetMapping
    public List<Factura> getAll() {
        return service.findAll();
    }
}
