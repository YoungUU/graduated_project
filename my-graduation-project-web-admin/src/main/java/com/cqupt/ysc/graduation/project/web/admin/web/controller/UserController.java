package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.commons.constant.ConstantUtils;
import com.cqupt.ysc.graduation.project.commons.constant.UrlUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.UserInfoDto;
import com.cqupt.ysc.graduation.project.domain.TbUser;
import com.cqupt.ysc.graduation.project.web.admin.Utils.EmailUtils;
import com.cqupt.ysc.graduation.project.web.admin.service.TbUserService;
import com.cqupt.ysc.graduation.project.web.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转到用户基本信息的详情页
     * @return
     */
    @RequestMapping(value = "basicinfo",method = RequestMethod.GET)
    public String getUserInfoByEamil(HttpServletRequest httpServletRequest,Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);

        UserInfoDto userInfoDto = userInfoService.getUserInfoByEmail(email);

        model.addAttribute("userInfo",userInfoDto);

        return "user_info";
    }

    @RequestMapping(value = "eduinfo",method = RequestMethod.GET)
    public String getUserInfoByEamil1(HttpServletRequest httpServletRequest,Model model){
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESION_USER);

        /**
         * 如果当前用户主信息读取失败，则返回主界面，让用户重新发送请求。
         */
        if (tbUser == null){
            return "redirect:/main";
        }

        String email = tbUser.getEmail();

        UserInfoDto userInfoDto = userInfoService.getUserInfoByEmail(email);

        model.addAttribute("userInfo",userInfoDto);

        return "user_eduinfo";
    }


    /**
     * 更新用户信息
     * @param httpServletRequest
     */
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public String updateUserInfoByEmail(HttpServletRequest httpServletRequest, UserInfoDto userInfoDto,Model model) {

        int flag = 0;
        userInfoDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));

        //判断是否有修改密码的权力
        //条件为password和repassword都非空且两个密码相等。否则将原始密码置空
        if (userInfoDto.getPassword() != null && httpServletRequest.getParameter("rePassword") != null) {
            if (userInfoDto.getPassword().equals(httpServletRequest.getParameter("rePassword"))) {
                //获取tbUser
                TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESION_USER);

                tbUser.setPhone(userInfoDto.getPhone());
                tbUser.setUsername(userInfoDto.getUsername());
                tbUser.setPassword(userInfoDto.getPassword());

                flag = 1;
                tbUserService.updatePwd(tbUser);
            }
        }

        if (flag == 0){
            String message = "两次输入的密码不一致，请重新输入！";
            model.addAttribute("message",message);
            return "user_info";
        }

        /**
         * 如果当前用户主信息读取失败，则返回主界面，让用户重新发送请求。
         */


        userInfoService.updateUserBasicByEmail(userInfoDto);

        return "redirect:/user/basicinfo";
    }
}
