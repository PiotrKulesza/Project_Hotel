package com.project.hotel.services;

import com.project.hotel.models.Role;

import java.util.List;

public interface IRoleService {
    public void postRole(Role role);
    public Boolean deleteRole(String id);
    public List<Role> getRoles();
}
