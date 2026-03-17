package com.npalacios.food_flow.modules.orders.services;

import com.npalacios.food_flow.modules.orders.entities.PedidoDetalle;
import com.npalacios.food_flow.modules.orders.repositories.PedidoDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoDetalleService {

    private final PedidoDetalleRepository repository;

    public PedidoDetalle save(PedidoDetalle entity) {
        return repository.save(entity);
    }

    public List<PedidoDetalle> findAll() {
        return repository.findAll();
    }

    public Optional<PedidoDetalle> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
