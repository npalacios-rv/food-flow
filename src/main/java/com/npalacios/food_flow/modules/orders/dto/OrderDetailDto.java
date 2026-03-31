package com.npalacios.food_flow.modules.orders.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDetailDto {
    private Integer idProduct;
    private Integer quantity;
    private BigDecimal unitPrice;
}
