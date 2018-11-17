package com.demo.tdd.service;

import com.demo.tdd.domain.Car;
import com.demo.tdd.exception.CarNotFoundException;
import com.demo.tdd.repository.CarRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    @Cacheable("cars")
    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if(car == null){
            throw new CarNotFoundException();
        }
        return car;
    }
}
