package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.commons.constant.ConstantUtils;
import com.cqupt.ysc.graduation.project.commons.constant.TimeUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.web.admin.Utils.EmailUtils;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/research")
public class ResearchController {
    @Autowired
    private ResearchService researchService;

    @RequestMapping(value = "/paper")
    public String getPapers(HttpServletRequest httpServletRequest,Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Paper> papers = researchService.getPapers(email);
        model.addAttribute("papers",papers);
        return "research_paper";
    }

    /**
     *跳转用户表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "paper_form";
    }

    /**
     * 新增论文
     */
    @RequestMapping(value = "savePaper",method = RequestMethod.POST)
    public String savePaper(HttpServletRequest httpServletRequest){
        if (httpServletRequest.getParameter("paperName")==null){
            return "paper_form";
        }
        //封装一个PaperDto

        PaperDto paperDto = new PaperDto();
        paperDto.setAuthor(httpServletRequest.getParameter("author"));
        paperDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));
        paperDto.setPaperName(httpServletRequest.getParameter("paperName"));
        paperDto.setNumber1(httpServletRequest.getParameter("number1"));
        paperDto.setStatus(httpServletRequest.getParameter("status"));
        paperDto.setUrl(httpServletRequest.getParameter("url"));
        paperDto.setReleaseTime(httpServletRequest.getParameter("releaseTime"));


        String end = researchService.savePaper(paperDto);
        System.out.println(end);

        System.out.println(paperDto);
        return "redirect:/research/paper";
    }

    /**
     * 删除paper
     */
    @RequestMapping(value = "delete")
    public String deletePaperById(){
        return "ok";
    }
}
