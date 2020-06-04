package com.project.hotel.services;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import com.project.hotel.models.Role;
import com.project.hotel.repositories.RoleRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hotel.models.User;
import com.project.hotel.repositories.UserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUsersById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {

		List<User> users = userRepository.findAll();
		AtomicReference<User> user = new AtomicReference<>(new User());
		Observable<List<User>> observer = Observable.just(users);

		observer.flatMap(Observable::fromIterable)
				.filter(s -> s.getEmail().equals(email) && s.getPassword().equals(password))
				.toList()
				.subscribe(s -> {
					user.set(s.get(0));
				});



		return user.get();

	}


	@Override
	public Boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return userRepository.existsById(id)==false;
	}

	@Override
	public void putPassword(String id, String password) {
		// TODO Auto-generated method stub

		User user = userRepository.findById(id).get();
		user.setPassword(password);
		userRepository.save(user);

	}

	@Override
	public void postUser(User user) {
		// TODO Auto-generated method stub
		user.setDateTime(new Date(Calendar.getInstance().getTime().getTime()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByRoleName("USER").get());
		user.setRoles(roles);
		userRepository.save(user);
	}

	@Override
	public void putUserRole(String userId, String roleName) {

		User user = userRepository.findById(userId).get();
		Set<Role> roles = user.getRoles();
		roles.add(roleRepository.findByRoleName(roleName).get());
		user.setRoles(roles);
		userRepository.save(user);
	}

}
