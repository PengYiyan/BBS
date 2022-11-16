package com.bbs.data.dao;

import com.bbs.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, Integer> {
}
