package com.npalacios.food_flow.modules.billing.services;

import com.npalacios.food_flow.modules.billing.entities.FacturaPago;
import com.npalacios.food_flow.modules.billing.repositories.FacturaPagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturaPagoService {

    private final FacturaPagoRepository repository;

    public FacturaPago save(FacturaPago entity) {
        return repository.save(entity);
    }

    public List<FacturaPago> findAll() {
        return repository.findAll();
    }

    public Optional<FacturaPago> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
