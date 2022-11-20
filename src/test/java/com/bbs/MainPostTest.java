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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        MainPostVO mainPostVO = new MainPostVO();
        mainPostVO.setTitle("你好");
        mainPostVO.setType(PostType.SHARE);
        mainPostVO.setSubjectType(SubjectType.ENGLISH);
        mainPostVO.setContent("I will introduce it to you");
        mainPostVO.setUserId("12345");
        mainPostVO.setTime(sdf.format(new Date()));
        mainPostVO.setName("道士");
        mainPostVO.setPicture("123456789");

        List<String> resources = new ArrayList<>();
        resources.add("abc");
        mainPostVO.setResources(resources);

        System.out.println(mainPostController.newMainPost(mainPostVO));
    }

    @Test
    void testTimeFormat(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        System.out.println(date);
        System.out.println(sdf.format(date));
    }

    @Test
    void testGetPost(){
//        System.out.println(mainPostController.getPostDetail("637a25e6d7da864eb74a1dec"));
    }

    @Test
    void testDelete(){
//        System.out.println(mainPostController.deleteMainPost("637a25e6d7da864eb74a1dec"));
    }

    @Test
    void testMatch(){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true);

        MainPost mainPost = new MainPost();
        mainPost.setTitle("Have");
        Example<MainPost> mainPostExample = Example.of(mainPost,matcher);
        List<MainPost> all = mainPostDao.findAll(mainPostExample);
        System.out.println(all.size());

    }
}
