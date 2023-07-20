package com.rgmcode.nf_car_integration_test;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository = new CarRepository();

    public void addCar(Car car) {
        CarRepository.addCar(car);
    }

    public List<Car> getCars() {
        return carRepository.getCars();
    }

    public void deleteById(String id) {
        carRepository.deleteById(id);
    }

    public void updateById(String id, Car car) {
        carRepository.updateById(id, car);
    }
}
