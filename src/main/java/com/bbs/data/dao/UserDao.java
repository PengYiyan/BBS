package com.bbs.data.dao;

import com.bbs.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDao extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
