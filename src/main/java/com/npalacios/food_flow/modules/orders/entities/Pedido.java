package com.npalacios.food_flow.modules.orders.entities;

import com.npalacios.food_flow.modules.auth.entities.Usuario;
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
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id") // Nullable por defecto para invitados
    private Usuario usuario;

    @Column(name = "nombre_invitado", length = 100)
    private String nombreInvitado;

    @Column(name = "numero_mesa")
    private Integer numeroMesa;

    @Column(nullable = false, length = 20)
    private String estado = "PENDIENTE";

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private Date fechaCreacion;

}
