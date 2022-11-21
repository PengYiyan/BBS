package com.bbs.vo;

import com.bbs.enums.PostType;
import com.bbs.enums.SubjectType;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户发表or点击主题帖时传递的VO
 * @author Peng Yiyan
 * @since 2022/11/19
 */
@Data
public class MainPostVO {

    private String postId;
    private String title;
    private PostType type;
    private SubjectType subject;
    private String content;
    private String userId;
    //前端传入的时间是String
    private String time;
    private List<String> resources;
    private List<String> pics;
    private List<String> replys;

    //新增发帖用户的name和头像
    private String name;
    private String picture;

}
