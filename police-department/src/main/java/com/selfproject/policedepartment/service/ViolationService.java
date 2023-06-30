package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.PolicemanAbout;
import com.selfproject.policedepartment.entity.Violation;
import com.selfproject.policedepartment.enumeration.ViolationTypeEnum;
import com.selfproject.policedepartment.repository.ViolationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationService {

    private final ViolationRepository violationRepository;
    private final PolicemanAboutService policemanAboutService;
    private final UserService userService;

    @Autowired
    public ViolationService(ViolationRepository violationRepository, PolicemanAboutService policemanAboutService, UserService userService) {
        this.violationRepository = violationRepository;
        this.policemanAboutService = policemanAboutService;
        this.userService = userService;
    }

    public List<Violation> getAllViolationsByUserPIN(String pin) {
        return violationRepository
                .findViolationsByUserPin(pin)
                .orElseThrow();
    }

    public List<Violation> getAllElectronicSlipsByUserPIN(String pin) {
        return violationRepository
                .findElectronicSlipsByUserPin(pin)
                .orElseThrow();
    }

    public List<Violation> getAllNotHandedToDriverViolationsByUserPIN(String pin) {
        return violationRepository
                .findNotHandedToDriverViolationsByPIN(pin)
                .orElseThrow();
    }

    public Violation getViolationByIDAndUserPIN(String pin, String id) {
        return violationRepository
                .findViolationByIDAndUserPIN(pin, id)
                .orElseThrow();
    }

    public List<Violation> getPenalDecreesByUserPIN(String pin) {
        return violationRepository
                .findPenalDecreesByUserPin(pin)
                .orElseThrow();
    }

    public Violation createViolation(ViolationTypeEnum violationType, String cause, String pin) {
        Violation violation = new Violation();
        violation.setViolationType(violationType);
        violation.setCause(cause);
        violation.setPolicemanAbout(findPolicemanByUsername());
        violation.setUser(userService.getUserByPIN(pin));
        violation.setHandedToDriver(false);
        return violation;
    }


    private PolicemanAbout findPolicemanByUsername() {
        String username = userService.getCurrentLoggedUserUserName();
        return policemanAboutService
                .getPolicemanAboutByUserName(username);
    }
}
