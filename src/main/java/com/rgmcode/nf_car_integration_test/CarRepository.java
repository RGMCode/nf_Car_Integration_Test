package com.rgmcode.nf_car_integration_test;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private static List<Car> cars = new ArrayList<>();

    public static void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void deleteById(String id) {
        int index = -1;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }

        cars.remove(index);
    }

    public void updateById(String id, Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                cars.set(i, car);
                break;
            }
        }
    }
}
