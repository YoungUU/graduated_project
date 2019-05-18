package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao {
    UserInfo getUserInfoByEmail(String email);
    void updateUserInfoByEmail(UserInfo userInfo);
    UserInfo search(UserInfo userInfo);
}
