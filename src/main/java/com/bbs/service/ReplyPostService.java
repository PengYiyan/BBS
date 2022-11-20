package com.bbs.service;

import com.bbs.vo.ReplyPostVO;
import com.bbs.vo.ResponseVO;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 * 回帖相关的服务接口
 */
public interface ReplyPostService {

    /**
     * 创建一个新的回帖
     * @param replyPostVO
     * @return
     */
    ResponseVO newReplyPost(ReplyPostVO replyPostVO);

    /**
     * 删除回帖
     * @param postId
     * @return
     */
    ResponseVO deleteReplyPost(String postId);
}
