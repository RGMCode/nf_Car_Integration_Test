package com.rgmcode.nf_car_integration_test;

import lombok.Data;

@Data
public class Car {
    private String id;
    private String manufacturer;
    private int tires;
    private boolean tuv;

    public Car(String id, String manufacturer, int tires, boolean tuv) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.tires = tires;
        this.tuv = tuv;
    }
}
