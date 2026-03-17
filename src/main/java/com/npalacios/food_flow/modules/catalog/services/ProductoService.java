package com.npalacios.food_flow.modules.catalog.services;

import com.npalacios.food_flow.modules.catalog.entities.Producto;
import com.npalacios.food_flow.modules.catalog.repositories.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public Producto save(Producto entity) {
        return repository.save(entity);
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Optional<Producto> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
