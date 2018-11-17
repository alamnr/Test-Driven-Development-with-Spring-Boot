package com.demo.tdd.repository;

import com.demo.tdd.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CarRepository extends CrudRepository<Car,Long> {
     Car findByName(String name) ;
}
