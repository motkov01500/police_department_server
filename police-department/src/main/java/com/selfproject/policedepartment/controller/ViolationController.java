package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.ViolationDTO;
import com.selfproject.policedepartment.dto.ViolationSearchByUserDTO;
import com.selfproject.policedepartment.dto.requests.CreateViolationRequest;
import com.selfproject.policedepartment.dto.requests.ViolationRequest;
import com.selfproject.policedepartment.dto.requests.ViolationSearchByUserRequest;
import com.selfproject.policedepartment.entity.Violation;
import com.selfproject.policedepartment.mapper.ViolationMapper;
import com.selfproject.policedepartment.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("violation")
public class ViolationController {

    private final ViolationService violationService;
    private final ViolationMapper violationMapper;

    @Autowired
    public ViolationController(ViolationService violationService, ViolationMapper violationMapper) {
        this.violationService = violationService;
        this.violationMapper = violationMapper;
    }

    @GetMapping("get-all-by-pin")
    public ResponseEntity<List<ViolationDTO>> getViolationsByUserPIN(@RequestBody ViolationRequest violationRequest) {
        List<Violation> violations = violationService
                .getAllViolationsByUserPIN(violationRequest.getPin());

        List<ViolationDTO> mappedViolations = violations
                .stream()
                .map(violationMapper::mapViolationToViolationDTO)
                .toList();

        return new ResponseEntity<>(mappedViolations, HttpStatus.OK) ;
    }

    @GetMapping("get-electronic-slips-by-pin")
    public ResponseEntity<List<ViolationDTO>> getElectronicSlipsByUserPIN(@RequestBody ViolationRequest violationRequest) {
        List<Violation> electronicSlips = violationService
                .getAllElectronicSlipsByUserPIN(violationRequest.getPin());

        List<ViolationDTO> mappedElectronicSlips = electronicSlips
                .stream()
                .map(violationMapper::mapViolationToViolationDTO)
                .toList();
        return new ResponseEntity<>(mappedElectronicSlips, HttpStatus.OK);
    }

    @GetMapping("get-penal-decrees-by-pin")
    public ResponseEntity<List<ViolationDTO>> getPenalDecreesByUserPIN(@RequestBody ViolationRequest violationRequest) {
        List<Violation> penalDecrees = violationService
                .getPenalDecreesByUserPIN(violationRequest.getPin());

        List<ViolationDTO> mappedPenalDecrees = penalDecrees
                .stream()
                .map(violationMapper::mapViolationToViolationDTO)
                .toList();
        return new ResponseEntity<>(mappedPenalDecrees, HttpStatus.OK);
    }

    @GetMapping("get-not-handed-to-driver-by-pin")
    public ResponseEntity<List<ViolationDTO>> getViolationsNotHandedToDriveByUserPIN(@RequestBody ViolationRequest violationRequest) {
        List<Violation> notHandedToDriverViolations = violationService
                .getAllNotHandedToDriverViolationsByUserPIN(violationRequest.getPin());

        List<ViolationDTO> mappedNotHandedToDriverViolations = notHandedToDriverViolations
                .stream()
                .map(violationMapper::mapViolationToViolationDTO)
                .toList();

        return new ResponseEntity<>(mappedNotHandedToDriverViolations, HttpStatus.OK);
    }

    @GetMapping("get-violation-by-id-pin")
    public ResponseEntity<ViolationSearchByUserDTO> getViolationByIDAndUserPIN(@RequestBody ViolationSearchByUserRequest violationSearchByUserRequest) {
        Violation violation = violationService
                .getViolationByIDAndUserPIN(violationSearchByUserRequest.getPin(), violationSearchByUserRequest.getId());

        ViolationSearchByUserDTO mappedViolation = violationMapper.mapViolationToViolationSearchByUserDTO(violation);
        return new ResponseEntity<>(mappedViolation,HttpStatus.OK);
    }

    @PostMapping("create-violation")
    public ResponseEntity<ViolationDTO> createViolation(@RequestBody CreateViolationRequest createRequest) {
        Violation violation = violationService
                .createViolation(createRequest.getViolationType(),createRequest.getCause(), createRequest.getPin());

        ViolationDTO mappedViolation = violationMapper.mapViolationToViolationDTO(violation);
        return new ResponseEntity<>(mappedViolation, HttpStatus.CREATED);
    }
}
