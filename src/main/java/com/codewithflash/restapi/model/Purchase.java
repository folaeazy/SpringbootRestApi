package com.codewithflash.restapi.model;

import java.math.BigDecimal;

public class Purchase {
    private int id;
    private String product;
    private BigDecimal price;

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProduct() {
        return product;
    }
}
