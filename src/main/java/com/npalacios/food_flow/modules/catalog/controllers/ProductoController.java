package com.npalacios.food_flow.modules.catalog.controllers;

import com.npalacios.food_flow.modules.catalog.entities.Producto;
import com.npalacios.food_flow.modules.catalog.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/productos")
@RequiredArgsConstructor
public class ProductoController {

    @Autowired
    private final ProductoService service;

    @GetMapping
    public List<Producto> getAll() {
        return service.findAll();
    }
}
