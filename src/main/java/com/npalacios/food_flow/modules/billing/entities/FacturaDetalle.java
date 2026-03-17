package com.npalacios.food_flow.modules.billing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "factura_detalles")
public class FacturaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;

    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    @Column(name = "nombre_producto_snap", nullable = false, length = 150)
    private String nombreProductoSnap;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "subtotal_linea", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotalLinea;

}
