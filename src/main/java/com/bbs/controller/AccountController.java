package com.bbs.controller;

import com.bbs.service.AccountService;
import com.bbs.vo.AccountFormVO;
import com.bbs.vo.ResponseVO;
import com.bbs.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 */
@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public ResponseVO login(@RequestBody AccountFormVO accountFormVO){
        return ResponseVO.buildSuccess(accountService.login(accountFormVO));
    }

    @GetMapping("/register")
    public ResponseVO register(@RequestBody AccountFormVO accountFormVO){
        return ResponseVO.buildSuccess(accountService.register(accountFormVO));
    }

    @GetMapping("/update")
    public ResponseVO update(@RequestBody UserInfoVO userInfoVO){
        return ResponseVO.buildSuccess(accountService.update(userInfoVO));
    }

}
