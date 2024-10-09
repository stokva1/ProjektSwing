package com.example.projektswing.service;

import com.example.projektswing.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarServiceImpl implements CarService {
    ArrayList<Car> cars = new ArrayList<>();

    @Override
    public ArrayList<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        if(id > -1 && id < cars.size()){
            return cars.get(id);
        }
        return null;
    }

    @Override
    public void deleteCar(int id) {
        if(id > -1 && id < cars.size()){
            cars.remove(id);
        }
    }

    @Override
    public void saveCar(Car car) {
        if(car.getId() > -1 && car.getId() < cars.size())
            cars.remove(car.getId());
        cars.add(car);
    }

}
