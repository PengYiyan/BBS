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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        mainPost.setSubject(mainPostVO.getSubject());
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
    public List<MainPostVO> getMainPosts(String userId,String title, String startTime,String endTime) throws ParseException {
        List<MainPost> ori;
        //存在标题的情况
        if(title != null && title.length()!=0){
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                    .withIgnoreCase(true);

            MainPost mainPost = new MainPost();
            mainPost.setTitle(title);
            if(userId!=null && userId.length()!=0){
                mainPost.setUserId(userId);
            }
            Example<MainPost> mainPostExample = Example.of(mainPost,matcher);
            ori = mainPostDao.findAll(mainPostExample);
        }else if(userId!=null && userId.length()!=0){
            MainPost mainPost = new MainPost();
            mainPost.setUserId(userId);
            Example<MainPost> mainPostExample = Example.of(mainPost);
            ori = mainPostDao.findAll(mainPostExample);
        }else {//如果不筛选标题和用户id，则返回所有帖子用于后续筛选时间范围
            ori = mainPostDao.findAll();
        }

        //如果不对时间进行筛选，直接返回上一步的结果
        if(startTime==null||endTime==null){

            return convertToVO(ori);
        }

//        System.out.println("ori: "+ori.size());

        //完成第一步标题筛选，接下来对时间进行筛选
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar start = Calendar.getInstance();
        start.setTime(sdf.parse(startTime));
        Calendar end = Calendar.getInstance();
        end.setTime(sdf.parse(endTime));

        List<MainPost> res = new ArrayList<>();
        for(MainPost mainPost : ori){

            Calendar tar = Calendar.getInstance();
            tar.setTime(sdf.parse(mainPost.getTime()));

            //在区间之内
            if(tar.after(start) && tar.before(end)){
                res.add(mainPost);
            }
            //在区间边界
            if(tar.equals(start) || tar.equals(end)){
                res.add(mainPost);
            }
        }

        return convertToVO(ori);
    }

    public List<MainPostVO> convertToVO(List<MainPost> a){
        List<MainPostVO> res = new ArrayList<>();
        for(MainPost mainPost :a){
            MainPostVO newOne = new MainPostVO();
            newOne.setPostId(mainPost.getPostId().toHexString());
            newOne.setTitle(mainPost.getTitle());
            newOne.setType(mainPost.getType());
            newOne.setSubject(mainPost.getSubject());
            newOne.setContent(mainPost.getContent());
            newOne.setUserId(mainPost.getUserId());
            newOne.setTime(mainPost.getTime());
            newOne.setResources(mainPost.getResources());
            newOne.setPics(mainPost.getPics());
            newOne.setReplys(mainPost.getReplys());
            newOne.setName(mainPost.getName());
            newOne.setPicture(mainPost.getPicture());
            res.add(newOne);
        }

        return res;
    }

    public MainPostVO convertToVO2(MainPost mainPost){
        MainPostVO newOne = new MainPostVO();
        newOne.setPostId(mainPost.getPostId().toHexString());
        newOne.setTitle(mainPost.getTitle());
        newOne.setType(mainPost.getType());
        newOne.setSubject(mainPost.getSubject());
        newOne.setContent(mainPost.getContent());
        newOne.setUserId(mainPost.getUserId());
        newOne.setTime(mainPost.getTime());
        newOne.setResources(mainPost.getResources());
        newOne.setPics(mainPost.getPics());
        newOne.setReplys(mainPost.getReplys());
        newOne.setName(mainPost.getName());
        newOne.setPicture(mainPost.getPicture());
        return newOne;
    }

    @Override
    public MainPostVO getPostDetail(String postId){
        return convertToVO2(mainPostDao.findById(new ObjectId(postId)).get());
    }
}
