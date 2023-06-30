package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.Car;
import com.selfproject.policedepartment.entity.Vignette;
import com.selfproject.policedepartment.enumeration.VignetteTypeEnum;
import com.selfproject.policedepartment.repository.VignetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VignetteService {

    private final VignetteRepository vignetteRepository;
    private final CarService carService;

    @Autowired
    public VignetteService(VignetteRepository vignetteRepository, CarService carService) {
        this.vignetteRepository = vignetteRepository;
        this.carService = carService;
    }

    public Vignette getVignetteByCarNumberAndUserPIN(String carNumber, String pin) {
        return vignetteRepository
                .findVignetteOfCar(carNumber, pin)
                .orElseThrow();
    }

    public Vignette createVignetteToTheCar(String carNumber, LocalDate expiryDate, VignetteTypeEnum vignetteType) {
        Car car = carService
                .getCarByCarNumber(carNumber);

        Vignette vignette = new Vignette();
        vignette.setExpiryDate(expiryDate);
        vignette.setCar(car);
        vignette.setVignetteType(vignetteType);
        vignetteRepository.save(vignette);
        return vignette;
    }
}
