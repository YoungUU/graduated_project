package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "mould")
public class MouldController {

    @RequestMapping(value = "moulds")
    public String moulds(HttpServletRequest httpServletRequest){
        return "mould";
    }
}
