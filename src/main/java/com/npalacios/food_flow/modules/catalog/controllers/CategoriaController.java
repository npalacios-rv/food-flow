package com.npalacios.food_flow.modules.catalog.controllers;

import com.npalacios.food_flow.modules.catalog.entities.Categoria;
import com.npalacios.food_flow.modules.catalog.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    @Autowired
    private final CategoriaService service;

    @GetMapping
    public List<Categoria> getAll() {
        return service.findAll();
    }
}
