package com.project.hotel.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.hotel.models.User;

public interface UserRepository extends MongoRepository<User, String>{


}
