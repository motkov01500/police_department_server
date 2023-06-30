package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Integer> {

    @Query("From DrivingLicense DR WHERE DR.isVerified = false")
    Optional<List<DrivingLicense>> findNotVerifiedDrivingLicenses();
}
