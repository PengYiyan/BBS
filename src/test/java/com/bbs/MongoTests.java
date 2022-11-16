package com.bbs;

import com.bbs.data.dao.UserDao;
import com.bbs.data.entity.User;
import com.bbs.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testMongoAdd(){
        User user = new User();
        user.setUserId(1);
        user.setEmail("123");
        user.setName("p.nju");
        user.setRole(UserRole.STUDENT);
        user.setPhone("123456789");
        user.setPicture("abc");
        user.setPassword("111111");

        userDao.save(user);
    }
}
