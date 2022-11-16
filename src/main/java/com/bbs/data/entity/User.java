package com.bbs.data.entity;

import com.bbs.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 用户信息
 * @since 2022/11/15
 * @author Py
 */
@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class User {

    /**
     * 用户的id
     */
    @Id
    @Field("user_id")
    private Integer userId;

    /**
     * 用户的名称
     */
    @Field("name")
    private String name;

    /**
     * 邮箱
     */
    @Field("email")
    private String email;

    /**
     * 手机
     */
    @Field("phone")
    private String phone;

    /**
     * 用户密码
     */
    @Field("password")
    private String password;

    /**
     * 用户身份
     */
    @Field("role")
    private UserRole role;

    /**
     * 用户头像
     */
    @Field("picture")
    private String picture;

}
