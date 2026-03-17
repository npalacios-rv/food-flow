package com.npalacios.food_flow.modules.billing.controllers;

import com.npalacios.food_flow.modules.billing.entities.FacturaPago;
import com.npalacios.food_flow.modules.billing.services.FacturaPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/billing/factura-pagos")
@RequiredArgsConstructor
public class FacturaPagoController {

    @Autowired
    private final FacturaPagoService service;

    @GetMapping
    public List<FacturaPago> getAll() {
        return service.findAll();
    }
}
