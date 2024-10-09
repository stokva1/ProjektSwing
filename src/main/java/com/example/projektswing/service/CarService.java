package com.example.projektswing.service;

import com.example.projektswing.model.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface CarService {
     ArrayList<Car> getAllCars();
     Car getCarById(int id);
     void saveCar(Car car);
     void deleteCar(int id);
}
