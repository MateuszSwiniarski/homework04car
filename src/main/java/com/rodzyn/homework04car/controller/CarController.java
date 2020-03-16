package com.rodzyn.homework04car.controller;

import com.rodzyn.homework04car.model.Car;
import com.rodzyn.homework04car.model.Color;
import com.rodzyn.homework04car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCar(Model model){
        model.addAttribute("cars", carService.getCars());
        return "car";
    }

    @GetMapping("/add")
    public String addCar(Model model){
        model.addAttribute("newCar", new Car());
        model.addAttribute("colors", Color.values());
        return "newcar";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car){
        carService.addCar(car);
        System.out.println(car);
        return "redirect:/cars";
    }
}
