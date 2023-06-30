package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.Car;
import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final UserService userService;

    @Autowired
    public CarService(CarRepository carRepository, UserService userService) {
        this.carRepository = carRepository;
        this.userService = userService;
    }

    public List<Car> getUserCarsByPIN(String pin) {
        return carRepository
                .findCarsByUserPIN(pin)
                .orElseThrow();
    }

    public Car getCarByCarNumberAndUserPIN(String carNumber, String pin) {
        return carRepository
                .findCarByCarNumberAndUserPIN(carNumber, pin)
                .orElseThrow();
    }

    public List<Car> getCurrentUserCars() {
        String currentLoggedUserName = userService.getCurrentLoggedUserUserName();

        return carRepository
                .findCarsToCurrentLoggedUser(currentLoggedUserName)
                .orElseThrow();
    }

    public Car getCarByCarNumber(String carNumber) {
        return carRepository
                .findCarByCarNumber(carNumber)
                .orElseThrow();
    }

    public Car createCar(String carNumber, LocalDate insuranceEndDate, String model, LocalDate yearManufacture) {
        User user = userService.currentLoggedUser();
        Car car = new Car();
        car.setCarNumber(carNumber);
        car.setUser(user);
        car.setYearManufacture(yearManufacture);
        car.setModel(model);
        car.setInsuranceEndDate(insuranceEndDate);
        carRepository.save(car);
        return car;
    }
}
