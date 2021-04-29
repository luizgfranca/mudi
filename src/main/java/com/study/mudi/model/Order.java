package com.study.mudi.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Order {

    private String name;
    private BigDecimal value;
    private LocalDate deliverDate;
    private String productUrl;
    private String imgUrl;
    private String description;

}
