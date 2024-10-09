package com.example.projektswing.controller;


import com.example.projektswing.model.Car;
import com.example.projektswing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detailCar(Model model, @PathVariable int id) {
        Car car = carService.getCarById(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "detail";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String createCar(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("edit", false);
        return "edit";
    }

    @GetMapping("/edit/{id}")
    public String editCar(Model model, @PathVariable int id) {
        Car car = carService.getCarById(id);
        if(car != null){
            car.setId(id);
            model.addAttribute("car", car);
            model.addAttribute("edit", true);
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute Car car) {
        carService.saveCar(car);
        return "redirect:/";
    }
}
