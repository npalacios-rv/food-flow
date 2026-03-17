package com.npalacios.food_flow.modules.billing.services;

import com.npalacios.food_flow.modules.billing.entities.MetodoPago;
import com.npalacios.food_flow.modules.billing.repositories.MetodoPagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetodoPagoService {

    private final MetodoPagoRepository repository;

    public MetodoPago save(MetodoPago entity) {
        return repository.save(entity);
    }

    public List<MetodoPago> findAll() {
        return repository.findAll();
    }

    public Optional<MetodoPago> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
