package com.bbs.data.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReplyPost extends MongoRepository<ReplyPost, Integer> {
}
