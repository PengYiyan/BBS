package com.bbs.data.entity;

import com.bbs.enums.PostType;
import com.bbs.enums.SubjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;
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
    private ObjectId postId;

    /**
     * 帖子标题
     */
    @Field("title")
    private String title;

    /**
     * 帖子类型 提问or资源or整理
     */
    @Field("type")
    private PostType type;

    /**
     * 帖子所属的科目类型
     */
    @Field("subject")
    private SubjectType subject;

    /**
     * 帖子内容
     */
    @Field("content")
    private String content;

    /**
     * 发帖人的id
     */
    @Field("user_id")
    private String userId;

    /**
     * 新增：发帖用户的名字
     */
    @Field("name")
    private String name;

    /**
     * 新增：发帖用户的头像
     */
    @Field("picture")
    private String picture;

    /**
     * 发帖时间
     */
    @Field("time")
    private Date time;

    /**
     * 资源的urls
     */
    @Field("resources")
    private List<String> resources;

    /**
     * 图片的urls
     */
    @Field("pics")
    private List<String> pics;

    /**
     * 回帖id集合
     */
    @Field("replys")
    private List<String> replys;

}
