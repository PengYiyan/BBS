package com.bbs.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户发表or点击回帖帖时传递的VO
 * @author Peng Yiyan
 * @since 2022/11/19
 */
@Data
public class ReplyPostVO {

    private String postId;
    private String mainId;
    private String userId;
    private String content;
    private String name;
    //新增用户的头像
    private String picture;
    //前端传入的时间是String
    private String time;
    private int floor;
    //新增回复的目标楼层（回复的是哪一层）
    private int replyFloor;
    private List<String> pics;


}
