package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViolationRepository extends JpaRepository<Violation, String> {

    @Query("From Violation V JOIN V.user U JOIN U.drivingLicense DR WHERE DR.pin = :pin")
    Optional<List<Violation>> findViolationsByUserPin(@Param("pin") String pin);

    @Query("From Violation V JOIN V.user U JOIN U.drivingLicense DR WHERE DR.pin = :pin AND V.violationType = electronic_slip")
    Optional<List<Violation>> findElectronicSlipsByUserPin(@Param("pin") String pin);

    @Query("From Violation V JOIN V.user U JOIN U.drivingLicense DR WHERE DR.pin = :pin AND V.violationType = penal_decree")
    Optional<List<Violation>> findPenalDecreesByUserPin(@Param("pin") String pin);

    @Query("From Violation V JOIN V.user U JOIN U.drivingLicense DR WHERE DR.pin = :pin AND V.isHandedToDriver = false")
    Optional<List<Violation>> findNotHandedToDriverViolationsByPIN(@Param("pin") String pin);

    @Query("From Violation V JOIN V.user U JOIN U.drivingLicense DR WHERE DR.pin = :pin AND V.id = :id")
    Optional<Violation> findViolationByIDAndUserPIN(@Param("pin") String pin, @Param("id") String id);
}
