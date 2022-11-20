package com.bbs;

import com.bbs.data.dao.TestTypeDao;
import com.bbs.data.dao.UserDao;
import com.bbs.data.entity.TestType;
import com.bbs.data.entity.User;
import com.bbs.enums.UserRole;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TestTypeDao testTypeDao;

    @Test
    void testMongoAdd(){
        User user = new User();
//        user.setUserId(1);
        user.setEmail("123");
        user.setName("p.nju");
        user.setRole(UserRole.STUDENT);
        user.setPhone("123456789");
        user.setPicture("abc");
        user.setPassword("111111");

        userDao.save(user);
    }

    @Test
    void testTestType(){
        TestType testType = new TestType();
        testType.setName("haveATest");

        testTypeDao.save(testType);
    }

    @Test
    void testObjectIdCompare(){
        //测试ObjectId和String的对比
//        System.out.println(testTypeDao.findByName("haveATest").getTestId().equals("6379eec45ad35472839a105b"));
        System.out.println(testTypeDao.findByName("haveATest").getTestId().toHexString().equals("6379fb76cbe2ee557fbde1e4"));
    }

    @Test
    void testObjectId(){
//        System.out.println(testTypeDao.findById(new ObjectId("6379eec45ad35472839a105b")).get());
//        System.out.println(testTypeDao.findById(new ObjectId("6379f8fee6787100f8d15893")));
        System.out.println(testTypeDao.findById(new ObjectId("6379fb76cbe2ee557fbde1e4")));
    }
}
