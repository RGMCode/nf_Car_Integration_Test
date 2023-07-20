package com.rgmcode.nf_car_integration_test;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private CarService carService = new CarService();

    @PostMapping
    public void post(@RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping
    public List<Car> get() {
        return carService.getCars();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        carService.deleteById(id);
    }

    @PutMapping("/api/car/{id}")
    public void putById(@PathVariable String id, @RequestBody Car car) {
        carService.updateById(id, car);
    }

}
