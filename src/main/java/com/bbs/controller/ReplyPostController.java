package com.bbs.controller;

import com.bbs.service.ReplyPostService;
import com.bbs.vo.ReplyPostVO;
import com.bbs.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 */
@RestController
@CrossOrigin
@RequestMapping("/replypost")
public class ReplyPostController {
    private final ReplyPostService replyPostService;

    @Autowired
    public ReplyPostController(ReplyPostService replyPostService){
        this.replyPostService = replyPostService;
    }

    @GetMapping("/newReplyPost")
    public ResponseVO newReplyPost(@RequestBody ReplyPostVO replyPostVO){
        return ResponseVO.buildSuccess(replyPostService.newReplyPost(replyPostVO));
    }

    @GetMapping("/deleteReplyPost")
    public ResponseVO deleteReplyPost(@RequestParam(value = "postId") Integer postId){
        return ResponseVO.buildSuccess(replyPostService.deleteReplyPost(postId));
    }
}
