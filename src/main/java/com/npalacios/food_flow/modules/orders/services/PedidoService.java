package com.npalacios.food_flow.modules.orders.services;

import com.npalacios.food_flow.modules.orders.entities.Pedido;
import com.npalacios.food_flow.modules.orders.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;

    public Pedido save(Pedido entity) {
        return repository.save(entity);
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }

    public Optional<Pedido> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
