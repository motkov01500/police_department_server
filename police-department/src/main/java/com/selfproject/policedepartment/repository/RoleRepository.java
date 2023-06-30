package com.selfproject.policedepartment.repository;

import com.selfproject.policedepartment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("From Role R WHERE R.name = :name")
    Optional<Role> findRoleByName(@Param("name") String name);
}
