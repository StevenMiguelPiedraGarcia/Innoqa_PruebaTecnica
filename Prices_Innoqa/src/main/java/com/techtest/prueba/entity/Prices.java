package com.techtest.prueba.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRICES")
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "BRAND_ID")
    private long brandId;
    @Column(name = "PRODUCT_ID")
    private long productId;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "PRICE_LIST")
    private int priceList;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "CURR")
    private String curr;

}
