package com.study.mudi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal value;
    private LocalDate deliverDate;
    private String productUrl;
    private String imgUrl;
    private String description;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

}
