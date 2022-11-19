package com.bbs.service;

import com.bbs.data.dao.MainPostDao;
import com.bbs.data.entity.MainPost;
import com.bbs.vo.MainPostVO;
import com.bbs.vo.ResponseVO;

import java.util.Date;
import java.util.List;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 * 主贴相关操作的服务接口
 */
public interface MainPostService {

    /**
     * 用户发布新主题帖
     * @param mainPostVO
     * @return
     */
    ResponseVO newMainPost(MainPostVO mainPostVO);

    /**
     * 用户删除自己发表的主题帖
     * @param postId
     * @return
     */
    ResponseVO deleteMainPost(Integer postId);

    /**
     * 根据筛选条件返回post列表，筛选条件包括标题（关键词查询）、时间
     * @param title,time,type,subject
     */
    List<MainPost> getMainPosts(String title, Date time);

    /**
     * 根据帖子id返回帖子
     * @param postId
     * @return
     */
    MainPost getPostDetail(Integer postId);

}
