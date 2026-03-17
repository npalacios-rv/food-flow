package com.npalacios.food_flow.modules.billing.controllers;

import com.npalacios.food_flow.modules.billing.entities.FacturaDetalle;
import com.npalacios.food_flow.modules.billing.services.FacturaDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/billing/factura-detalles")
@RequiredArgsConstructor
public class FacturaDetalleController {

    @Autowired
    private final FacturaDetalleService service;

    @GetMapping
    public List<FacturaDetalle> getAll() {
        return service.findAll();
    }
}
