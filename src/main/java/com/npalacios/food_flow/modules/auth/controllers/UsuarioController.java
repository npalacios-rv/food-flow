package com.npalacios.food_flow.modules.auth.controllers;

import com.npalacios.food_flow.modules.auth.entities.Usuario;
import com.npalacios.food_flow.modules.auth.dto.AuthResponseDTO;
import com.npalacios.food_flow.modules.auth.dto.LoginRequestDTO;
import com.npalacios.food_flow.modules.auth.services.AuthService;
import com.npalacios.food_flow.modules.auth.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.findAll();
    }
}
