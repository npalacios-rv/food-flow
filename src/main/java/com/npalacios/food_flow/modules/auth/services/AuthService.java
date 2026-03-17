package com.npalacios.food_flow.modules.auth.services;

import com.npalacios.food_flow.common.security.JwtService;
import com.npalacios.food_flow.modules.auth.dto.AuthResponseDTO;
import com.npalacios.food_flow.modules.auth.dto.LoginRequestDTO;
import com.npalacios.food_flow.modules.auth.entities.Usuario;
import com.npalacios.food_flow.modules.auth.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO login(LoginRequestDTO request) {

        // 1. Autentica - si falla lanza BadCredentialsException automáticamente
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Usuario user = (Usuario) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(user);

        return AuthResponseDTO.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .nombre(user.getNombre())
                .rol(user.getRol().getNombre())
                .build();
    }
}
