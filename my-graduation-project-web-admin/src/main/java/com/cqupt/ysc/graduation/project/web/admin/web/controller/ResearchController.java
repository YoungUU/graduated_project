package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.commons.constant.ConstantUtils;
import com.cqupt.ysc.graduation.project.commons.constant.TimeUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.domain.TbUser;
import com.cqupt.ysc.graduation.project.web.admin.Utils.EmailUtils;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

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
    public String form(Model model) {
        return "paper_form";
    }

    /**
     * 新增论文
     */
    @RequestMapping(value = "savePaper",method = RequestMethod.POST)
    public String savePaper(HttpServletRequest httpServletRequest,PaperDto paperDto){
        if (httpServletRequest.getParameter("paperName")==null){
            return "paper_form";
        }

        paperDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));

        //封装完成，进行插入。
        researchService.savePaper(paperDto);

        return "redirect:/research/paper";
    }

    /**
     * 删除paper
     */
    @RequestMapping(value = "delete")
    public String deletePaperById(Long id){
        researchService.deletePaperById(id);
        return "redirect:/research/paper";
    }
}
