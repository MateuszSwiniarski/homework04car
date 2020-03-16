package com.rodzyn.homework04car.service;

import com.rodzyn.homework04car.model.Car;
import com.rodzyn.homework04car.model.Color;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    public CarServiceImp(){
        carList = new ArrayList<>();
        carList.add(new Car(1L, "audi", "A5", Color.BLACK));
        carList.add(new Car(2L, "prosche", "911", Color.RED));
        carList.add(new Car(3L, "bmw", "i8", Color.WHITE));
    }

    private List<Car> carList;

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        Optional<Car> first = carList.stream().filter(car -> car.getId() == id).findFirst();
        return first;
    }

    @Override
    public List<Car> getCarByColor(String color) {
        List<Car> carColor = carList.stream().filter(car -> car.getColor().equals(color)).collect(Collectors.toList());
        return carColor;
    }

    @Override
    public List<Car> getCarByMark(String mark) {
        List<Car> carMark = carList.stream().filter(car -> car.getMark().equals(mark)).collect(Collectors.toList());
        return carMark;
    }

    @Override
    public boolean addCar(Car car) {
        boolean add = carList.add(car);
        return true;
    }

    @Override
    public boolean modCar(Car newCar) {
        Optional<Car> first = getCars().stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        getCars().remove(first);
        boolean add = carList.add(newCar);
        return true;
    }

    @Override
    public void removeCar(Car car) {
        carList.remove(car);
    }

    @Override
    public void removeCarById(Long id) {
        carList.removeIf(car -> car.getId() == id);
    }
}