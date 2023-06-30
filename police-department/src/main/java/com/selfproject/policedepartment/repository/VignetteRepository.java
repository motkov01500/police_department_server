package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.Vignette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VignetteRepository extends JpaRepository<Vignette, Integer> {

    @Query("From Vignette V LEFT JOIN V.car C JOIN C.user U JOIN U.drivingLicense DR WHERE C.carNumber = :carNumber AND DR.pin = :pin")
    Optional<Vignette> findVignetteOfCar(@Param("carNumber") String carNumber, @Param("pin") String pin);
}
