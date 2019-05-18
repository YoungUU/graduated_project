package com.cqupt.ysc.graduation.project.web.admin.service;

import com.cqupt.ysc.graduation.project.domain.Dto.UserInfoDto;

public interface UserInfoService {
    UserInfoDto getUserInfoByEmail(String email);

    String updateUserBasicByEmail(UserInfoDto userInfoDto);

    UserInfoDto search(String keyword);
}
