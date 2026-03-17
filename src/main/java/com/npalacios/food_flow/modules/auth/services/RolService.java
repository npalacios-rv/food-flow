package com.npalacios.food_flow.modules.auth.services;

import com.npalacios.food_flow.modules.auth.entities.Rol;
import com.npalacios.food_flow.modules.auth.repositories.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository repository;

    public Rol save(Rol entity) {
        return repository.save(entity);
    }

    public List<Rol> findAll() {
        return repository.findAll();
    }

    public Optional<Rol> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
