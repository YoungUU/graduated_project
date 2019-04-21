package com.cqupt.ysc.graduation.project.web.admin.service.test;

import com.cqupt.ysc.graduation.project.domain.Dto.UserInfoDto;
import com.cqupt.ysc.graduation.project.web.admin.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class UserInfoServiceTest {
    @Autowired
    UserInfoService userInfoService;

    @Test
    public void testGetUserInfoByEmail(){
        UserInfoDto userInfoDto = userInfoService.getUserInfoByEmail("admin@cqupt.com");
        System.out.println(userInfoDto.toString());
    }

    @Test
    public void testUpdate(){
        UserInfoDto userInfoDto = userInfoService.getUserInfoByEmail("admin@cqupt.com");
        userInfoDto.setCompany("OPPO");
        userInfoService.updateUserBasicByEmail(userInfoDto);
    }
}
