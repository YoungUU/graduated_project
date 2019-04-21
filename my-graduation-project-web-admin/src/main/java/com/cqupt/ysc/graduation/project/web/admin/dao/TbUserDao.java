package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {
    /**
     * 查询用户表全部信息
     * @return
     */
    public List<TbUser> selectAll();

    /**
     * 根据邮箱查询用户信息
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
