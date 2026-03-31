package com.npalacios.food_flow.modules.orders.services;

import com.npalacios.food_flow.modules.catalog.entities.Producto;
import com.npalacios.food_flow.modules.dto.StandardResponse;
import com.npalacios.food_flow.modules.orders.dto.OrderDto;
import com.npalacios.food_flow.modules.orders.entities.Pedido;
import com.npalacios.food_flow.modules.orders.entities.PedidoDetalle;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@RequiredArgsConstructor
public class GestionPedidoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(GestionPedidoService.class);
    private final PedidoService pedidoService;
    private final PedidoDetalleService pedidoDetalleService;

    public StandardResponse getAllPedidos(){
        StandardResponse response = new StandardResponse();
        try {
            response.setResponse(pedidoService.findAll());
            response.setResponseCode(1);
            response.setResponseMessage("Exito");
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
            response.setResponseCode(0);
            response.setResponseMessage("Error");
        }

        return response;
    }

    public StandardResponse createOrder(OrderDto orderDto){
        StandardResponse response = new StandardResponse();

        try {
            Pedido pedido = new Pedido();
            pedido.setNombreInvitado(orderDto.getNameClient());
            pedido.setFechaCreacion(new Date());
            pedido.setEstado("ACTIVO");
            pedido.setNumeroMesa(orderDto.getTableNumber());
            pedidoService.save(pedido);

            orderDto.getDetails().forEach(orderDetailDto -> {
                PedidoDetalle pedidoDetalle = new PedidoDetalle();
                pedidoDetalle.setCantidad(orderDetailDto.getQuantity());
                Producto producto = new Producto();
                producto.setId(orderDetailDto.getIdProduct());
                pedidoDetalle.setProducto(producto);
                pedidoDetalle.setPrecioUnitarioSnap(orderDetailDto.getUnitPrice());
                pedidoDetalle.setPedido(pedido);
                pedidoDetalleService.save(pedidoDetalle);
            });
            response.setResponseCode(1);
            response.setResponseMessage("Exito");
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
            response.setResponseCode(0);
            response.setResponseMessage("Error");
        }
        return response;
    }
}
