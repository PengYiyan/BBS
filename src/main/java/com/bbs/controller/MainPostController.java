package com.bbs.controller;

import com.bbs.service.MainPostService;
import com.bbs.vo.MainPostVO;
import com.bbs.vo.ResponseVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 */
@RestController
@CrossOrigin
@RequestMapping("/mainPost")
public class MainPostController {
    private final MainPostService mainPostService;

    @Autowired
    public MainPostController(MainPostService mainPostService){
        this.mainPostService = mainPostService;
    }

    @PostMapping("/newMainPost")
    public ResponseVO newMainPost(@RequestBody MainPostVO mainPostVO){
        return ResponseVO.buildSuccess(mainPostService.newMainPost(mainPostVO));
    }

    @GetMapping("/deleteMainPost")
    public ResponseVO deleteMainPost(@RequestParam(value = "postId") String postId){
        return ResponseVO.buildSuccess(mainPostService.deleteMainPost(postId));
    }

    @GetMapping("/getMainPosts")
    public ResponseVO getMainPosts(@RequestParam(value = "userId",required = false) String userId,
                                   @RequestParam(value = "title",required = false) String title,
                                   @RequestParam(value = "startTime",required = false) String startTime,
                                   @RequestParam(value = "endTime",required = false) String endTime) throws ParseException {
        System.out.println(title);
        return ResponseVO.buildSuccess(mainPostService.getMainPosts(userId,title,startTime,endTime));
    }

    @GetMapping("/getPostDetail")
    public ResponseVO getPostDetail(@RequestParam(value = "postId") String postId){
        return ResponseVO.buildSuccess(mainPostService.getPostDetail(postId));
    }

    @GetMapping("convert")
    public String convert(@RequestParam(value = "postId") ObjectId a){
        return a.toHexString();
    }

}
