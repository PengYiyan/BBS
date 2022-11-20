package com.bbs.service.impl;

import com.bbs.data.dao.MainPostDao;
import com.bbs.data.dao.ReplyPostDao;
import com.bbs.data.entity.MainPost;
import com.bbs.data.entity.ReplyPost;
import com.bbs.service.ReplyPostService;
import com.bbs.vo.ReplyPostVO;
import com.bbs.vo.ResponseVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyPostServiceImpl implements ReplyPostService {

    @Autowired
    private ReplyPostDao replyPostDao;
    @Autowired
    private MainPostDao mainPostDao;

    @Override
    public ResponseVO newReplyPost(ReplyPostVO replyPostVO){
        ReplyPost replyPost = new ReplyPost();
        replyPost.setMainId(replyPostVO.getMainId());
        replyPost.setUserId(replyPostVO.getUserId());
        replyPost.setContent(replyPostVO.getContent());
        replyPost.setName(replyPostVO.getName());
        replyPost.setPicture(replyPostVO.getPicture());
        replyPost.setTime(replyPostVO.getTime());
        replyPost.setFloor(replyPostVO.getFloor());
        replyPost.setReplyFloor(replyPostVO.getReplyFloor());

        if(replyPostVO.getPics()==null){
            replyPost.setPics(replyPostVO.getPics());
        }else {
            replyPost.setPics(replyPostVO.getPics());
        }

        replyPostDao.save(replyPost);

        //在mainPost主贴中增加回帖的编号
        MainPost mainPost = mainPostDao.findById(new ObjectId(replyPostVO.getMainId())).get();
        Example<ReplyPost> replyPostExample = Example.of(replyPost);
        List<ReplyPost> all = replyPostDao.findAll(replyPostExample);
        String replyPostId = all.get(all.size()-1).getPostId().toHexString();

        List<String> replyIds = mainPost.getReplys();
        replyIds.add(replyPostId);
        mainPost.setReplys(replyIds);
        mainPostDao.save(mainPost);

        return ResponseVO.buildSuccess();

    }

    @Override
    public ResponseVO deleteReplyPost(String postId){

        //删除主贴中的对应id
        ReplyPost replyPost = replyPostDao.findById(new ObjectId(postId)).get();
        MainPost mainPost = mainPostDao.findById(new ObjectId(replyPost.getMainId())).get();

        List<String> replyIds = mainPost.getReplys();
        replyIds.remove(postId);
        mainPost.setReplys(replyIds);
        mainPostDao.save(mainPost);

        replyPostDao.deleteById(new ObjectId(postId));
        return ResponseVO.buildSuccess();
    }
}
