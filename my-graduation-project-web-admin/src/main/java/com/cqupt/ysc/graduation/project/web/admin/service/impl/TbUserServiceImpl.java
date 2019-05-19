package com.cqupt.ysc.graduation.project.web.admin.service.impl;

import com.cqupt.ysc.graduation.project.domain.TbUser;
import com.cqupt.ysc.graduation.project.web.admin.dao.TbUserDao;
import com.cqupt.ysc.graduation.project.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

    private final TbUserDao tbUserDao;

    @Autowired
    public TbUserServiceImpl(TbUserDao tbUserDao) {
        this.tbUserDao = tbUserDao;
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = tbUserDao.getByEmail(email);
        if (tbUser != null){
            //明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //判断加密后的密码和数据库中存放的密码是否匹配，匹配则表示允许登陆
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public void updatePwd(TbUser tbUser) {
        String md5Password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
        tbUser.setPassword(md5Password);
        tbUserDao.update(tbUser);
    }
}
