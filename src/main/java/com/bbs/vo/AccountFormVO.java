package com.bbs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户注册or登录账号时传递的VO
 * @author Peng Yiyan
 * @since 2022/11/18
 */
@Data
public class AccountFormVO {

    private String name;
    private String email;
    private String phone;
    private String password;

    public AccountFormVO(){}

    //登录时传入账号密码（邮箱作为账号）
    public AccountFormVO(String email,String password){
        this.email = email;
        this.password = password;
    }

    //注册时传入基础信息
    public AccountFormVO(String name, String email, String phone, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

}
