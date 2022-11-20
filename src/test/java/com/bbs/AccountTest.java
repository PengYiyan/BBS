package com.bbs;

import com.bbs.controller.AccountController;
import com.bbs.data.dao.UserDao;
import com.bbs.service.AccountService;
import com.bbs.vo.AccountFormVO;
import com.bbs.vo.UserInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTest {
    @Autowired
    private AccountController accountController;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserDao userDao;

    @Test
    void testRegister(){
        AccountFormVO accountFormVO = new AccountFormVO();
        accountFormVO.setName("道士你好");
        accountFormVO.setEmail("690780775@qq.com");
        accountFormVO.setPassword("123456");
        accountFormVO.setPhone("18176877095");

        accountController.register(accountFormVO);
    }

    @Test
    void testLogin(){
        AccountFormVO accountFormVO = new AccountFormVO();
        accountFormVO.setEmail("690780775@qq.com");
        accountFormVO.setPassword("123456");

        System.out.println(accountController.login(accountFormVO));
    }

    @Test
    void testUpdate(){
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId("6379fe8acf883673cc1aae22");
        userInfoVO.setPassword("654321");
        userInfoVO.setPicture("ababab");

        System.out.println(accountController.update(userInfoVO));
    }
}
