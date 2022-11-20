package com.bbs.data.dao;

import com.bbs.data.entity.ReplyPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReplyPostDao extends MongoRepository<ReplyPost, ObjectId> {
}
