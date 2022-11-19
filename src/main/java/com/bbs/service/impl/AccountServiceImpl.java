package com.bbs.service.impl;

import com.bbs.data.dao.UserDao;
import com.bbs.data.entity.User;
import com.bbs.service.AccountService;
import com.bbs.vo.AccountFormVO;
import com.bbs.vo.ResponseVO;
import com.bbs.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String ACCOUNT_NOT_EXIST = "账号不存在";
    private final static String WRONG_PSW = "密码错误";

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseVO login(AccountFormVO accountFormVO){
        String email = accountFormVO.getEmail();
        Optional<User> result = userDao.findByEmail(email);
        //如果对应的email查找不到用户，返回账号不存在
        if(!result.isPresent()){
            return ResponseVO.buildFailure(ACCOUNT_NOT_EXIST);
        }
        User res = result.get();
        //密码错误
        if(!result.get().getPassword().equals(accountFormVO.getPassword())){
            return ResponseVO.buildFailure(WRONG_PSW);
        }

        return ResponseVO.buildSuccess(new UserInfoVO(res.getUserId(),res.getName(),res.getEmail(),res.getPhone(),res.getPassword(),res.getPicture()));
    }

    @Override
    public ResponseVO register(AccountFormVO accountFormVO){
        String email = accountFormVO.getEmail();
        Optional<User> result = userDao.findByEmail(email);
        //如果该邮箱已经注册过账号，返回账号已存在
        if(result.isPresent()){
            return ResponseVO.buildFailure(ACCOUNT_EXIST);
        }
        User user = new User();
        user.setName(accountFormVO.getName());
        user.setEmail(accountFormVO.getEmail());
        user.setPassword(accountFormVO.getPassword());
        user.setPhone(accountFormVO.getPhone());

        return ResponseVO.buildSuccess(userDao.save(user));
    }

    @Override
    public ResponseVO uploadPic(int userId,String picture){
        Optional<User> result = userDao.findById(userId);
        if(!result.isPresent()){
            return ResponseVO.buildFailure(ACCOUNT_NOT_EXIST);
        }
        User user = userDao.findById(userId).get();
        user.setPicture(picture);

        return ResponseVO.buildSuccess(userDao.save(user));
    }

    @Override
    public ResponseVO update(UserInfoVO userInfoVO){
        User user = userDao.findById(userInfoVO.getId()).get();
        user.setName(userInfoVO.getName());
        user.setPassword(userInfoVO.getPassword());
        user.setEmail(userInfoVO.getEmail());
        user.setPhone(userInfoVO.getPhone());

        return ResponseVO.buildSuccess(userDao.save(user));
    }
}
