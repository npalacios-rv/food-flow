package com.npalacios.food_flow.modules.auth.repositories;

import com.npalacios.food_flow.modules.auth.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
