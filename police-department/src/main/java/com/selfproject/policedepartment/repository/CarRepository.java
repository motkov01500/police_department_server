package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("FROM Car C LEFT JOIN C.user U JOIN U.drivingLicense DR WHERE DR.pin = :pin")
    Optional<List<Car>> findCarsByUserPIN(@Param("pin") String pin);

    @Query("From Car C LEFT JOIN C.user U JOIN U.drivingLicense DR WHERE C.carNumber = :carNumber AND DR.pin = :pin")
    Optional<Car> findCarByCarNumberAndUserPIN(@Param("carNumber") String carNumber, @Param("pin") String pin);

    @Query("From Car C LEFT JOIN C.user U WHERE U.username = :username")
    Optional<List<Car>> findCarsToCurrentLoggedUser(@Param("username") String username);

    @Query("From Car C WHERE C.carNumber = :carNumber")
    Optional<Car> findCarByCarNumber(@Param("carNumber") String carNumber);
}