package com.project.hotel.services;

import java.util.List;

import com.project.hotel.models.Role;
import com.project.hotel.models.User;

public interface IUserService {
	
	public List<User> getUsers();
	public User getUsersById(String id);
	public User getUserByEmailAndPassword(String email, String password);
	public Boolean deleteUser(String id);
	public void putPassword(String id, String password);
	public void postUser(User user);
	public void putUserRole(String userId, String roleName);
	
}
