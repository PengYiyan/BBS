package com.bbs.vo;


import lombok.Data;

/**
 * 用户修改个人信息时传递的VO
 * @author Peng Yiyan
 * @since 2022/11/18
 */
@Data
public class UserInfoVO {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String picture;

    public UserInfoVO(){}

    public UserInfoVO(String id,String name,String email,String phone,String password,String picture){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.picture = picture;
    }
}
