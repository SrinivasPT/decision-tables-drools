package com.edge.drools;

import lombok.Data;

@Data
public class Driver {
    private String name = "Mr Joe Blogs";
    private Integer age = Integer.valueOf(30);
    private Integer priorClaims = Integer.valueOf(0);
    private String  locationRiskProfile = "LOW";


}
