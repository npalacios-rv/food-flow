package com.npalacios.food_flow.modules.catalog.services;

import com.npalacios.food_flow.modules.catalog.entities.Categoria;
import com.npalacios.food_flow.modules.catalog.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria save(Categoria entity) {
        return repository.save(entity);
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Optional<Categoria> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
