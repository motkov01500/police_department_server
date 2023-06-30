package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.PolicemanAbout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicemanAboutRepository extends JpaRepository<PolicemanAbout, Integer> {

    @Query("From PolicemanAbout PA LEFT JOIN PA.user U where U.username = :username")
    Optional<PolicemanAbout> findPolicemanByUserName(@Param("username") String username);
}
