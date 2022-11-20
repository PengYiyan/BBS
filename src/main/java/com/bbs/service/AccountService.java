package com.bbs.service;

import com.bbs.data.entity.User;
import com.bbs.vo.AccountFormVO;
import com.bbs.vo.ResponseVO;
import com.bbs.vo.UserInfoVO;

/**
 * @author Peng Yiyan
 * @since 2022/11/17
 * 处理个人用户操作的服务接口
 */
public interface AccountService {

    /**
     * 登录
     * @param accountFormVO
     * @return
     */
    ResponseVO login(AccountFormVO accountFormVO);

    /**
     * 注册
     * @param accountFormVO
     * @return
     */
    ResponseVO register(AccountFormVO accountFormVO);

//    /**
//     * 上传头像
//     * @param userId, picture
//     * @return
//     */
//    ResponseVO uploadPic(int userId,String picture);

    /**
     * 更新用户信息
     * @param userInfoVO
     * @return
     */
    ResponseVO update(UserInfoVO userInfoVO);

}
