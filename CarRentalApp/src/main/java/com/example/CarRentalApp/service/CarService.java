package com.example.CarRentalApp.service;

import com.example.CarRentalApp.entity.Car;
import com.example.CarRentalApp.entity.User;
import com.example.CarRentalApp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserService userService;

    public Car rentACar(Car car) {

        return carRepository.save(car);
    }

    public List<Car> findAllCar(Long id) {
        return carRepository.findCarByUserId(id);
    }
}
