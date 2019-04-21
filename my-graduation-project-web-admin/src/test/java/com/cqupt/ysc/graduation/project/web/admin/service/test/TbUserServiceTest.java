package com.cqupt.ysc.graduation.project.web.admin.service.test;

import com.cqupt.ysc.graduation.project.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest{

    @Autowired
    private TbUserService tbUserService;

//    @Test
//    public void testSelectAll(){
//        List<TbUser> tbUsers = tbUserService.selectAll();
//        for (TbUser tbUser: tbUsers
//             ) {
//            System.out.println(tbUser.getUsername());
//        }
//    }

    @Test
    public void testMD5(){
        System.out.println(DigestUtils.md5DigestAsHex("cqupt".getBytes()));
    }
}

