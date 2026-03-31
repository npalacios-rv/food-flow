package com.npalacios.food_flow.modules.dto;

import lombok.Data;

@Data
public class StandardResponse {
    private Object response;
    private String responseMessage;
    private Integer responseCode;
}
