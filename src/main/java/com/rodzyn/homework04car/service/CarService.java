package com.rodzyn.homework04car.service;

import com.rodzyn.homework04car.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();
    Optional<Car> getCarById(Long id);
    List<Car> getCarByColor(String color);
    List<Car> getCarByMark(String mark);
    boolean addCar(Car car);
    boolean modCar(Car car);
    void removeCar(Car car);
    void removeCarById(Long id);
}
