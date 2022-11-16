package com.bbs.data.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainPost extends MongoRepository<MainPost, Integer> {
}
