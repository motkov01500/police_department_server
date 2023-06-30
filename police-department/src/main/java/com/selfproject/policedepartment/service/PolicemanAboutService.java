package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.PolicemanAbout;
import com.selfproject.policedepartment.repository.PolicemanAboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicemanAboutService {

    private final PolicemanAboutRepository policemanAboutRepository;

    @Autowired
    public PolicemanAboutService(PolicemanAboutRepository policemanAboutRepository) {
        this.policemanAboutRepository = policemanAboutRepository;
    }

    public PolicemanAbout getPolicemanAboutByUserName(String username) {
        return policemanAboutRepository
                .findPolicemanByUserName(username)
                .orElseThrow();
    }
}
