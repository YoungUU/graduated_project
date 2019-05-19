package com.cqupt.ysc.graduation.project.web.admin.service;

import com.cqupt.ysc.graduation.project.domain.TbUser;


public interface TbUserService {

    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

    void updatePwd(TbUser tbUser);
}
