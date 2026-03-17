package com.npalacios.food_flow.modules.billing.entities;

import com.npalacios.food_flow.modules.orders.entities.Pedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false, unique = true)
    private Pedido pedido;

    @Column(name = "numero_control", unique = true, length = 20)
    private String numeroControl;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal iva;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "fecha_emision", insertable = false, updatable = false)
    private LocalDateTime fechaEmision;

}
