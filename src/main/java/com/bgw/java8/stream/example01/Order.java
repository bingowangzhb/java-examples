package com.bgw.java8.stream.example01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@AllArgsConstructor
public class Order {
    private String orderId;

    private BigDecimal serviceAmount;

    private BigDecimal productAmount;
}
