package com.example.projektswing.controller;


import com.example.projektswing.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CarController {
    private List<Car> cars;

    @GetMapping("/")
    public String listCars(Model model) {
        cars.add(new Car("abc", "red", 2, 10));
        model.addAttribute("cars", cars);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detailCar(@PathVariable int id, Model model) {
        model.addAttribute("car", cars.get(id));
        model.addAttribute("id", id);
        return "detail";
    }
}
