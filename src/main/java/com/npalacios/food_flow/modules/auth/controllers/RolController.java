package com.npalacios.food_flow.modules.auth.controllers;

import com.npalacios.food_flow.modules.auth.entities.Rol;
import com.npalacios.food_flow.modules.auth.services.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/roles")
@RequiredArgsConstructor
public class RolController {

    @Autowired
    private final RolService service;

    @GetMapping
    public List<Rol> getAll() {
        return service.findAll();
    }
}
