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
 * 回帖，主贴下回复的主楼层，可以带图
 * @since 2022/11/15
 * @author Py
 */
@Document(collection = "replypost")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class ReplyPost {

    /**
     * 回帖的id
     */
    @Id
    @Field("id")
    private int postId;

    /**
     * 回帖的内容
     */
    @Field("content")
    private String content;

    /**
     * 对应主贴的id
     */
    @Field("main_id")
    private int mainId;

    /**
     * 回帖人的id
     */
    @Field("user_id")
    private int userId;

    /**
     * 被回复人的昵称
     */
    @Field("username")
    private String name;

    /**
     * 回帖时间
     */
    @Field("time")
    private Date time;

    /**
     * 回帖楼层
     */
    @Field("floor")
    private int floor;

    /**
     * 图片的urls
     */
    @Field("pics")
    private List<String> pics;

//    /**
//     * 楼中楼集合
//     */
//    @Field("replys")
//    private List<WithinReply> replys;

}
