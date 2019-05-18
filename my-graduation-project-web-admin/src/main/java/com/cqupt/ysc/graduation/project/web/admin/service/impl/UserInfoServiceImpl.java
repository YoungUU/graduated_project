package com.cqupt.ysc.graduation.project.web.admin.service.impl;

import com.cqupt.ysc.graduation.project.commons.constant.TimeUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.UserInfoDto;
import com.cqupt.ysc.graduation.project.domain.UserInfo;
import com.cqupt.ysc.graduation.project.web.admin.dao.UserInfoDao;
import com.cqupt.ysc.graduation.project.web.admin.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    /**
     * 把个人详细信息拿出来
     * @param email
     * @return
     */
    @Override
    public UserInfoDto getUserInfoByEmail(String email) {
        UserInfo userinfo = userInfoDao.getUserInfoByEmail(email);
        UserInfoDto userInfoDto = new UserInfoDto();
        if (userinfo == null){
            System.out.println("数据库出错！信息没查到！");
            return userInfoDto;
        }
        BeanUtils.copyProperties(userinfo,userInfoDto);
        return userInfoDto;
    }

    @Override
    public String updateUserBasicByEmail(UserInfoDto userInfoDto) {
        if (userInfoDto == null){
            return "redirect:/main";
        }
        UserInfo userInfo = new UserInfo();

        userInfo.setUpdated(TimeUtils.getSystemTime());

        BeanUtils.copyProperties(userInfoDto,userInfo);
        userInfoDao.updateUserInfoByEmail(userInfo);

        return "ok";
    }

    @Override
    public UserInfoDto search(String keyword) {
        UserInfo userInfo = new UserInfo();

        userInfo.setNamePinyin(keyword);
        userInfo.setEnglishName(keyword);
        userInfo.setUsername(keyword);
        userInfo.setMainPosts(keyword);
        userInfo.setAcademicDegree(keyword);

        UserInfoDto userInfoDto = new UserInfoDto();
        BeanUtils.copyProperties(userInfoDao.search(userInfo),userInfoDto);

        return userInfoDto;
    }
}
