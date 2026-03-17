package com.npalacios.food_flow.modules.billing.services;

import com.npalacios.food_flow.modules.billing.entities.Factura;
import com.npalacios.food_flow.modules.billing.repositories.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturaService {

    private final FacturaRepository repository;

    public Factura save(Factura entity) {
        return repository.save(entity);
    }

    public List<Factura> findAll() {
        return repository.findAll();
    }

    public Optional<Factura> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
