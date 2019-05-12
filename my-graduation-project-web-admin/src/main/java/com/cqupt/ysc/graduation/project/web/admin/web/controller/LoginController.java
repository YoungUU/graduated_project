package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.commons.constant.ConstantUtils;
import com.cqupt.ysc.graduation.project.domain.TbUser;
import com.cqupt.ysc.graduation.project.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录逻辑
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest) {
        TbUser tbUser = tbUserService.login(email, password);

        //登陆失败
        if(tbUser == null){
            httpServletRequest.setAttribute("message","用户名或密码错误！");
            return login();
        }

        //登录成功
        else {
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESION_USER,tbUser);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return login();
    }
}
