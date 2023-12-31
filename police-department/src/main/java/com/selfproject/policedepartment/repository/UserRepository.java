package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User U WHERE U.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("From User U LEFT JOIN U.drivingLicense DR WHERE DR.pin = :pin")
    Optional<User> findByPIN(@Param("pin") String pin);
}
