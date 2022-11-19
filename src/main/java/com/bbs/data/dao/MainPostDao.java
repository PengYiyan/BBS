package com.bbs.data.dao;

import com.bbs.data.entity.MainPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainPostDao extends MongoRepository<MainPost, Integer> {
}
