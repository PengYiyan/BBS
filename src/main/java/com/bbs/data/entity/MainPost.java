package com.bbs.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * 主题帖，即显示在版块中的帖子
 * @since 2022/11/15
 * @author Py
 */
@Document(collection = "mainpost")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class MainPost {

    /**
     * 主贴的id
     */
    @Id
    @Field("id")
    private Integer postId;

    /**
     * 帖子标题
     */
    @Field("title")
    private String title;

    /**
     * 帖子内容
     */
    @Field("content")
    private String content;

    /**
     * 发帖人的id
     */
    @Field("user_id")
    private Integer userId;

    /**
     * 发帖时间
     */
    @Field("time")
    private Date time;

    /**
     * 回帖id集合
     */
    @Field("replys")
    private List<Integer> replys;

}