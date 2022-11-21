package com.bbs;

import com.bbs.controller.ReplyPostController;
import com.bbs.data.dao.ReplyPostDao;
import com.bbs.data.entity.ReplyPost;
import com.bbs.service.ReplyPostService;
import com.bbs.vo.ReplyPostVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ReplyPostTest {

    @Autowired
    private ReplyPostService replyPostService;
    @Autowired
    private ReplyPostController replyPostController;
    @Autowired
    private ReplyPostDao replyPostDao;

    @Test
    void testNewReply(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ReplyPostVO replyPost = new ReplyPostVO();
        replyPost.setMainId("637aec2531b24a78ed792423");
        replyPost.setUserId("123");
        replyPost.setContent("I do like it");
        replyPost.setName("道士123");
        replyPost.setPicture("abababababab");
        replyPost.setTime(sdf.format(new Date()));
        replyPost.setFloor(2);
        replyPost.setReplyFloor(1);

        System.out.println(replyPostController.newReplyPost(replyPost));
    }

    @Test
    void testDelete(){
//        System.out.println(replyPostController.deleteReplyPost("637a2a2e0fc0d42fb652582d"));
    }
}
