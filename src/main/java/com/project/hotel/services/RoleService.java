package com.project.hotel.services;

import com.project.hotel.models.Role;
import com.project.hotel.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService  implements  IRoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void postRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Boolean deleteRole(String id) {

        roleRepository.deleteById(id);
        return roleRepository.existsById(id)==false;


    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
