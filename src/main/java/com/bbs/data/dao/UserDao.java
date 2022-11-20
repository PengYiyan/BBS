package com.bbs.data.dao;

import com.bbs.data.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDao extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(String email);
}
