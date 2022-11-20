package com.bbs.service.impl;

import com.bbs.data.dao.MainPostDao;
import com.bbs.data.entity.MainPost;
import com.bbs.service.MainPostService;
import com.bbs.vo.MainPostVO;
import com.bbs.vo.ResponseVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MainPostServiceImpl implements MainPostService {
    private final static String POST_NOT_EXIST = "帖子不存在";

    @Autowired
    private MainPostDao mainPostDao;

    @Override
    public ResponseVO newMainPost(MainPostVO mainPostVO){
        MainPost mainPost = new MainPost();
        mainPost.setTitle(mainPostVO.getTitle());
        mainPost.setType(mainPostVO.getType());
        mainPost.setSubject(mainPostVO.getSubjectType());
        mainPost.setContent(mainPostVO.getContent());
        mainPost.setUserId(mainPostVO.getUserId());
        mainPost.setTime(mainPostVO.getTime());
        mainPost.setResources(mainPostVO.getResources());
        mainPost.setPics(mainPostVO.getPics());
        mainPost.setReplys(mainPostVO.getReplys());
        mainPost.setName(mainPostVO.getName());
        mainPost.setPicture(mainPostVO.getPicture());

        return ResponseVO.buildSuccess(mainPostDao.save(mainPost));
    }

    @Override
    public ResponseVO deleteMainPost(String postId){
        mainPostDao.deleteById(new ObjectId(postId));
        return ResponseVO.buildSuccess();
    }

    @Override
    public List<MainPost> getMainPosts(String title, String time){

        if(!(title == null||title.length()==0)){

        }else {//如果没有安装标题查找，则只筛选时间

        }

        return null;
    }

    @Override
    public MainPost getPostDetail(String postId){
        return mainPostDao.findById(new ObjectId(postId)).get();
    }
}
