package com.bbs.controller;

import com.bbs.service.MainPostService;
import com.bbs.vo.MainPostVO;
import com.bbs.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 */
@RestController
@CrossOrigin
@RequestMapping("/mainpost")
public class MainPostController {
    private final MainPostService mainPostService;

    @Autowired
    public MainPostController(MainPostService mainPostService){
        this.mainPostService = mainPostService;
    }

    @GetMapping("/newMainPost")
    public ResponseVO newMainPost(@RequestBody MainPostVO mainPostVO){
        return ResponseVO.buildSuccess(mainPostService.newMainPost(mainPostVO));
    }

    @GetMapping("/deleteMainPost")
    public ResponseVO deleteMainPost(@RequestParam(value = "postId") String postId){
        return ResponseVO.buildSuccess(mainPostService.deleteMainPost(postId));
    }

    @GetMapping("/getMainPosts")
    public ResponseVO getMainPosts(@RequestParam(value = "title") String title,@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime){
        return ResponseVO.buildSuccess(mainPostService.getMainPosts(title,startTime,endTime));
    }

    @GetMapping("/getPostDetail")
    public ResponseVO getPostDetail(@RequestParam(value = "postId") String postId){
        return ResponseVO.buildSuccess(mainPostService.getPostDetail(postId));
    }

}
