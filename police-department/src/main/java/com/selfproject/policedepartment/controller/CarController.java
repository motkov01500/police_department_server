package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.CarDTO;
import com.selfproject.policedepartment.dto.CarSearchByUserDTO;
import com.selfproject.policedepartment.dto.requests.CarPolicemanGetRequest;
import com.selfproject.policedepartment.dto.requests.CarUserGetRequest;
import com.selfproject.policedepartment.dto.requests.CreateCarRequest;
import com.selfproject.policedepartment.entity.Car;
import com.selfproject.policedepartment.mapper.CarMapper;
import com.selfproject.policedepartment.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @Autowired
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("get-cars-by-pin")
    public ResponseEntity<List<CarDTO>> getUserCarsByPIN(@RequestBody CarPolicemanGetRequest carUserGetRequest) {
        List<Car> userCars = carService
                .getUserCarsByPIN(carUserGetRequest.getPin());

        List<CarDTO> mappedCars = userCars
                .stream()
                .map(carMapper::mapCarToCarDTO)
                .toList();
        return new ResponseEntity<>(mappedCars, HttpStatus.OK);
    }

    @GetMapping("get-car-by-number-pin")
    public ResponseEntity<CarSearchByUserDTO> getUserCarByCarNumberAndUserPIN(@RequestBody CarUserGetRequest carUserGetRequest) {
        Car userCar = carService
                .getCarByCarNumberAndUserPIN(carUserGetRequest.getCarNumber(), carUserGetRequest.getPin());

        CarSearchByUserDTO mappedUserCar = carMapper.mapCarToCarSearchByUserDTO(userCar);
        return new ResponseEntity<>(mappedUserCar, HttpStatus.OK);
    }

    @GetMapping("get-current-user-cars")
    public ResponseEntity<List<CarSearchByUserDTO>> getCurrentLoggedUserCars() {
        List<Car> currentUserCars = carService.getCurrentUserCars();

        List<CarSearchByUserDTO> mappedCars = currentUserCars
                .stream()
                .map(carMapper::mapCarToCarSearchByUserDTO)
                .toList();
        return new ResponseEntity<>(mappedCars, HttpStatus.OK);
    }

    @PostMapping("create-car")
    public ResponseEntity<CarDTO> createCar(@RequestBody CreateCarRequest createCarRequest) {
        Car car = carService
                .createCar(createCarRequest.getCarNumber(), createCarRequest.getInsuranceEndDate(),
                        createCarRequest.getModel(), createCarRequest.getYearManufacture());

        CarDTO mappedCar = carMapper.mapCarToCarDTO(car);
        return new ResponseEntity<>(mappedCar, HttpStatus.CREATED);
    }
}
