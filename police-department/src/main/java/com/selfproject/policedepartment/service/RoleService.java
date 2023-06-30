package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.Role;
import com.selfproject.policedepartment.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleByName(String name) {
        return roleRepository
                .findRoleByName(name)
                .orElseThrow();
    }
}