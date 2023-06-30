package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.DrivingLicense;
import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.repository.DrivingLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DrivingLicenseService {

    private final DrivingLicenseRepository drivingLicenseRepository;
    private final UserService userService;

    @Autowired
    public DrivingLicenseService(DrivingLicenseRepository drivingLicenseRepository, UserService userService) {
        this.drivingLicenseRepository = drivingLicenseRepository;
        this.userService = userService;
    }

    public List<DrivingLicense> getNotVerifiedDrivingLicenses() {
        return drivingLicenseRepository
                .findNotVerifiedDrivingLicenses()
                .orElseThrow();
    }

    public DrivingLicense verifyDrivingLicenseByID(int id) {
        DrivingLicense drivingLicense = drivingLicenseRepository
                .findById(id)
                .orElseThrow();
        drivingLicense.setVerified(true);
        drivingLicenseRepository.save(drivingLicense);
        return drivingLicense;
    }

    public DrivingLicense addDrivingLicenseToUser(int licenseNumber, String address, LocalDate dateOfCreation, LocalDate expiryDate, String pin) {
        User currentUser = userService.currentLoggedUser();
        DrivingLicense drivingLicense = new DrivingLicense();
        drivingLicense.setLicenseNumber(licenseNumber);
        drivingLicense.setAddress(address);
        drivingLicense.setDateOfCreation(dateOfCreation);
        drivingLicense.setExpiryDate(expiryDate);
        drivingLicense.setPin(pin);
        drivingLicense.setUser(currentUser);
        drivingLicense.setVerified(false);
        drivingLicense.setPoints(30);
        drivingLicenseRepository.save(drivingLicense);
        return drivingLicense;
    }
}
