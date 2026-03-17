package com.npalacios.food_flow.modules.billing.services;

import com.npalacios.food_flow.modules.billing.entities.FacturaDetalle;
import com.npalacios.food_flow.modules.billing.repositories.FacturaDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturaDetalleService {

    private final FacturaDetalleRepository repository;

    public FacturaDetalle save(FacturaDetalle entity) {
        return repository.save(entity);
    }

    public List<FacturaDetalle> findAll() {
        return repository.findAll();
    }

    public Optional<FacturaDetalle> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
