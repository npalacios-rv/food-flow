package com.npalacios.food_flow.modules.orders.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

    private Integer id;
    private Integer idUser;
    private String nameClient;
    private Integer tableNumber;
    private String status;
    private List<OrderDetailDto> details;
}
