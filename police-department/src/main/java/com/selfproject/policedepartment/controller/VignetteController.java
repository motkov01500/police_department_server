package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.VignetteDTO;
import com.selfproject.policedepartment.dto.requests.CreateVignetteRequest;
import com.selfproject.policedepartment.dto.requests.VignetteGetRequest;
import com.selfproject.policedepartment.entity.Vignette;
import com.selfproject.policedepartment.mapper.VignetteMapper;
import com.selfproject.policedepartment.service.VignetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vignette")
public class VignetteController {

    private final VignetteService vignetteService;
    private final VignetteMapper vignetteMapper;

    @Autowired
    public VignetteController(VignetteService vignetteService, VignetteMapper vignetteMapper) {
        this.vignetteService = vignetteService;
        this.vignetteMapper = vignetteMapper;
    }

    @GetMapping("get-vignette-by-carnum-pin")
    public ResponseEntity<VignetteDTO> getVignetteByCarNumberAndUserPIN(@RequestBody VignetteGetRequest vignetteGetRequest) {
        Vignette vignette = vignetteService
                .getVignetteByCarNumberAndUserPIN(vignetteGetRequest.getCarNumber(), vignetteGetRequest.getPin());

        VignetteDTO mappedVignette = vignetteMapper.mapVignetteToVignetteDTO(vignette);
        return new ResponseEntity<>(mappedVignette, HttpStatus.OK);
    }

    @PostMapping("create-vignette")
    public ResponseEntity<VignetteDTO> createVignette(@RequestBody CreateVignetteRequest createVignetteRequest) {
        Vignette vignette = vignetteService
                .createVignetteToTheCar(createVignetteRequest.getCarNumber(),
                        createVignetteRequest.getExpiryDate(), createVignetteRequest.getVignetteTypeEnum());

        VignetteDTO mappedVignette = vignetteMapper.mapVignetteToVignetteDTO(vignette);
        return new ResponseEntity<>(mappedVignette, HttpStatus.CREATED);
    }
}
