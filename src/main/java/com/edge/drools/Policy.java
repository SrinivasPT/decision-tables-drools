package com.edge.drools;

import lombok.Data;

@Data
public class Policy {
    private String type = "COMPREHENSIVE";
    private boolean approved = false;
    private int discountPercent = 0;
    private int basePrice;

    public void applyDiscount(int discount) {
        discountPercent += discount;
    }
}
