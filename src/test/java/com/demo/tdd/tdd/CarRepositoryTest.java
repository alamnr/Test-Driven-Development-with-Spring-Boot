package com.demo.tdd.tdd;

import com.demo.tdd.domain.Car;
import com.demo.tdd.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByName_returnsCar() throws Exception{

        // In case of testing it will save in first level cache not flushed to the DB
        // and pick data from first level cache not from database
        //repository.save(new Car("prius","hybrid"));

        // test entity manager save data into database and it can be picked
        // from database as realtime application
        Car savedCar = testEntityManager.persistFlushFind(new Car("prius","hybrid"));
        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());


    }

    @Test
    public void getCar_returnsCarDetails() throws Exception{
        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo("prius");

    }

}
