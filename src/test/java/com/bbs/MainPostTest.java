package com.bbs;

import com.bbs.controller.MainPostController;
import com.bbs.data.dao.MainPostDao;
import com.bbs.data.entity.MainPost;
import com.bbs.enums.PostType;
import com.bbs.enums.SubjectType;
import com.bbs.service.MainPostService;
import com.bbs.vo.MainPostVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MainPostTest {
    @Autowired
    private MainPostService mainPostService;
    @Autowired
    private MainPostController mainPostController;
    @Autowired
    private MainPostDao mainPostDao;

    @Test
    void testNewPost(){
        MainPostVO mainPostVO = new MainPostVO();
        mainPostVO.setTitle("Have a good day");
        mainPostVO.setType(PostType.SHARE);
        mainPostVO.setSubjectType(SubjectType.ENGLISH);
        mainPostVO.setContent("I will introduce it to you");
        mainPostVO.setUserId("12345");
        mainPostVO.setTime(new Date());
        mainPostVO.setName("道士");
        mainPostVO.setPicture("123456789");

        List<String> resources = new ArrayList<>();
        resources.add("abc");
        mainPostVO.setResources(resources);

        System.out.println(mainPostController.newMainPost(mainPostVO));
    }

    @Test
    void testGetPost(){
        System.out.println(mainPostController.getPostDetail("637a25e6d7da864eb74a1dec"));
    }

    @Test
    void testDelete(){
        System.out.println(mainPostController.deleteMainPost("637a25e6d7da864eb74a1dec"));
    }
}
