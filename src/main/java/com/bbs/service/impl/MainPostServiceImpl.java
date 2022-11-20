package com.bbs.service.impl;

import com.bbs.data.dao.MainPostDao;
import com.bbs.data.entity.MainPost;
import com.bbs.service.MainPostService;
import com.bbs.vo.MainPostVO;
import com.bbs.vo.ResponseVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        mainPost.setName(mainPostVO.getName());
        mainPost.setPicture(mainPostVO.getPicture());
        mainPost.setReplys(new ArrayList<>());

        //可选项单独处理
        if(mainPostVO.getResources()==null){
            mainPost.setResources(new ArrayList<>());
        }else {
            mainPost.setResources(mainPostVO.getResources());
        }
        if(mainPostVO.getPics()==null){
            mainPost.setPics(new ArrayList<>());
        }else {
            mainPost.setPics(mainPostVO.getPics());
        }

        return ResponseVO.buildSuccess(mainPostDao.save(mainPost));
    }

    @Override
    public ResponseVO deleteMainPost(String postId){
        mainPostDao.deleteById(new ObjectId(postId));
        return ResponseVO.buildSuccess();
    }

    @Override
    public List<MainPost> getMainPosts(String title, String startTime,String endTime){
        List<MainPost> ori;

        if(!(title == null||title.length()==0)){
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                    .withIgnoreCase(true);

            MainPost mainPost = new MainPost();
            mainPost.setTitle(title);
            Example<MainPost> mainPostExample = Example.of(mainPost,matcher);
            ori = mainPostDao.findAll(mainPostExample);
        }else {//如果不筛选标题，则返回所有帖子用于后续筛选时间范围
            ori = mainPostDao.findAll();
        }


        //如果不对时间进行筛选，直接返回上一步的结果
        if(startTime==null||endTime==null){
            return ori;
        }
        //完成第一步标题筛选，接下来对时间进行筛选



        return null;
    }

    @Override
    public MainPost getPostDetail(String postId){
        return mainPostDao.findById(new ObjectId(postId)).get();
    }
}
