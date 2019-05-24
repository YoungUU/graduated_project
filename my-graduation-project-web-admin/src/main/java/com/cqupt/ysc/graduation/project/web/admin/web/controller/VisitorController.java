package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.domain.*;
import com.cqupt.ysc.graduation.project.domain.Dto.UserInfoDto;
import com.cqupt.ysc.graduation.project.web.admin.service.EducationService;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import com.cqupt.ysc.graduation.project.web.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/visitor")
public class VisitorController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ResearchService researchService;

    @Autowired
    private EducationService educationService;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(String keyword, Model model){

        UserInfoDto userInfoDto = userInfoService.search(keyword);

        if (userInfoDto == null){
            String message = "您寻找的老师不存在，建议您重新回忆一下！！";
            model.addAttribute("message",message);
            return "index";
        }

        //由于数据量较少，所以将email写死
        String email = userInfoDto.getEmail();
//          String email = "admin@cqupt.com";

        //用email去吧所有的信息拿出来
        List<Paper> papers = researchService.getPapers(email);
        List<Patent> patents = researchService.getPatents(email);
        List<Project> projects = researchService.getProjects(email);
        List<Reward> rewards = educationService.getRewards(email);
        List<Student> students = educationService.getStudents(email);

        model.addAttribute("userInfo",userInfoDto);
        model.addAttribute("papers",papers);
        model.addAttribute("patents",patents);
        model.addAttribute("projects",projects);
        model.addAttribute("rewards",rewards);
        model.addAttribute("students",students);

        return "resume";
    }
}
