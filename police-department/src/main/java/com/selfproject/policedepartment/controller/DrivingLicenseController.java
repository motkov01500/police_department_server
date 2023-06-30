package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.DrivingLicenseDTO;
import com.selfproject.policedepartment.dto.requests.CreateDrivingLicenseRequest;
import com.selfproject.policedepartment.dto.requests.UpdateVerificationDrivingLicenseRequest;
import com.selfproject.policedepartment.entity.DrivingLicense;
import com.selfproject.policedepartment.mapper.DrivingLicenseMapper;
import com.selfproject.policedepartment.service.DrivingLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("driving-license")
public class DrivingLicenseController {

    private final DrivingLicenseService drivingLicenseService;
    private final DrivingLicenseMapper drivingLicenseMapper;

    @Autowired
    public DrivingLicenseController(DrivingLicenseService drivingLicenseService, DrivingLicenseMapper drivingLicenseMapper) {
        this.drivingLicenseService = drivingLicenseService;
        this.drivingLicenseMapper = drivingLicenseMapper;
    }

    @GetMapping("get-not-verified")
    public ResponseEntity<List<DrivingLicenseDTO>> getNotVerifiedDrivingLicense() {
        List<DrivingLicense> notVerifiedDrivingLicenses = drivingLicenseService.getNotVerifiedDrivingLicenses();

        List<DrivingLicenseDTO> mappedDrivingLicenses = notVerifiedDrivingLicenses
                .stream()
                .map(drivingLicenseMapper::mapDrivingLicenseToDrivingLicenseDTO)
                .toList();
        return new ResponseEntity<>(mappedDrivingLicenses, HttpStatus.OK);
    }

    @PostMapping("create-driving-license")
    public ResponseEntity<DrivingLicenseDTO> addDrivingLicenseToCurrentUser(@RequestBody CreateDrivingLicenseRequest createRequest) {
        DrivingLicense createdDrivingLicense = drivingLicenseService
                .addDrivingLicenseToUser(createRequest.getLicenseNumber(), createRequest.getAddress(), createRequest.getDateOfCreation(),
                        createRequest.getExpiryDate(), createRequest.getPin());

        DrivingLicenseDTO mappedDrivingLicense = drivingLicenseMapper.mapDrivingLicenseToDrivingLicenseDTO(createdDrivingLicense);
        return new ResponseEntity<>(mappedDrivingLicense, HttpStatus.CREATED);
    }

    @PatchMapping("verify-by-id")
    public ResponseEntity<DrivingLicenseDTO> verifyDrivingLicenseByID(@RequestBody UpdateVerificationDrivingLicenseRequest verificationRequest) {
        DrivingLicense drivingLicense = drivingLicenseService.verifyDrivingLicenseByID(verificationRequest.getId());

        DrivingLicenseDTO mappedDrivingLicense = drivingLicenseMapper.mapDrivingLicenseToDrivingLicenseDTO(drivingLicense);
        return new ResponseEntity<>(mappedDrivingLicense, HttpStatus.OK);
    }
}
