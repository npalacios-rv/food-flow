package com.npalacios.food_flow.modules.auth.services;

import com.npalacios.food_flow.modules.auth.entities.Usuario;
import com.npalacios.food_flow.modules.auth.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario save(Usuario entity) {
        return repository.save(entity);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
