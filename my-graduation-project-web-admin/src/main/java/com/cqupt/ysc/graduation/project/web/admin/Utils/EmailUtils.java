package com.cqupt.ysc.graduation.project.web.admin.Utils;

import com.cqupt.ysc.graduation.project.commons.constant.ConstantUtils;
import com.cqupt.ysc.graduation.project.domain.TbUser;

import javax.servlet.http.HttpServletRequest;

public class EmailUtils {
    public static String getUserEmail(HttpServletRequest httpServletRequest){
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESION_USER);

        /**
         * 如果当前用户主信息读取失败，则返回主界面，让用户重新发送请求。
         */
        if (tbUser == null){
            return "redirect:/main";
        }

        String email = tbUser.getEmail();

        return email;
    }
}
