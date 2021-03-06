package com.cqupt.ysc.graduation.project.web.admin.web.controller;

import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Dto.PatentDto;
import com.cqupt.ysc.graduation.project.domain.Dto.ProjectDto;
import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.domain.Patent;
import com.cqupt.ysc.graduation.project.domain.Project;
import com.cqupt.ysc.graduation.project.web.admin.Utils.EmailUtils;
import com.cqupt.ysc.graduation.project.web.admin.Utils.ExcelUtils;
import com.cqupt.ysc.graduation.project.web.admin.Utils.ExportExcelUtil;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/research")
public class ResearchController {
    @Autowired
    private ResearchService researchService;
    static private Integer paperOrdNum;


    @RequestMapping("/uploadExcel")
    public String getExcel(HttpServletRequest request, MultipartFile file){
        List<Paper> papers = ExcelUtils.getListByExcelFile(file);
        String email = EmailUtils.getUserEmail(request);
        researchService.savePapers(papers ,email,paperOrdNum);
        return "redirect:/research/paper";
    }

    @RequestMapping(value = "/exportExcel")
    public String exportExcel(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws Exception {
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Paper> papers = researchService.getPapers(email);

        String title = "papar";

        List<Object[]>  dataList = new ArrayList<Object[]>();
        for (int i = 0;i<papers.size();i++){
            String[] string = papers.get(i).toString().split(",");
            for (int j = 0 ;j<string.length;j++){
                if (string[j].split("=").length == 1){
                    string[j] = string[j].split("=")[0];
                }else string[j] = string[j].split("=")[1];
            }
            dataList.add(string);
        }

        String[] rowName = {"id","论文名","编号","url",
                "发布时间","顺序","状态","作者",
                "发布者","email","删除标志","创建时间","更新时间"};
        ExportExcelUtil exportExcelUtil = new ExportExcelUtil(title,
                rowName,dataList, httpServletRequest, httpServletResponse);
        exportExcelUtil.exportData();

        return "redirect:/research/paper";
    }

    /**
     *所有Paper对外接口
     */
    @RequestMapping(value = "/paper")
    public String getPapers(HttpServletRequest httpServletRequest,Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Paper> papers = researchService.getPapers(email);
        Collections.sort(papers);
        paperOrdNum = papers.get(0).getOrdernum();
        model.addAttribute("papers",papers);
        return "research_paper";
    }

    /**
     *跳转用户表单页
     * @return
     */
    @RequestMapping(value = "formPaper",method = RequestMethod.GET)
    public String formPaper(Long id,Model model) {
        if (id != null){
            Paper paper = researchService.getPaperById(id);
            model.addAttribute("paper",paper);
        }
        return "paper_form";
    }

    /**
     * 新增论文
     */
    @RequestMapping(value = "savePaper",method = RequestMethod.POST)
    public String savePaper(HttpServletRequest httpServletRequest,PaperDto paperDto){
        if (paperDto == null){
            return "paper_form";
        }

        paperDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));
        paperDto.setOrdernum(paperOrdNum+1);

        //封装完成，进行插入。
        researchService.savePaper(paperDto);

        return "redirect:/research/paper";
    }

    /**
     * 删除paper
     */
    @RequestMapping(value = "deletePaper")
    public String deletePaperById(Long id){
        researchService.deletePaperById(id);
        return "redirect:/research/paper";
    }

    /**
     *编辑论文
     */
    @RequestMapping(value = "editPaper")
    public String editPaperById(Long id,PaperDto paperDto){
        paperDto.setId(id);
        researchService.updatePaperById(paperDto);
        return "redirect:/research/paper";
    }

    /**
     * 模糊查询
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "searchPaper",method = RequestMethod.POST)
    public String searchPaper(String keyword, Model model){
        List<Paper> papers = researchService.searchPaper(keyword);
        model.addAttribute("papers",papers);
        return "research_paper";
    }

    /**
     * 论文置顶
     */
    @RequestMapping(value = "paperToTop",method = RequestMethod.GET)
    public String paperToTop(Long id){
        PaperDto paperDto = new PaperDto();
        paperDto.setId(id);
        paperDto.setOrdernum(paperOrdNum+1);
        System.out.println(paperDto);
        researchService.updatePaperById(paperDto);
        return "redirect:/research/paper";
    }


    /**
     *所有Patent对外接口
     */
    @RequestMapping(value = "patent")
    public String getPatents(HttpServletRequest httpServletRequest,Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Patent> patents = researchService.getPatents(email);
        model.addAttribute("patents",patents);
        return "research_patent";
    }

    @RequestMapping(value = "formPatent",method = RequestMethod.GET)
    public String formPatent(Long id,Model model){
        if (id != null){
            Patent patent = researchService.getPatentById(id);
            model.addAttribute("patent",patent);
        }
        return "patent_form";
    }

    @RequestMapping(value = "savePatent",method = RequestMethod.POST)
    public String savePatent(HttpServletRequest httpServletRequest, PatentDto patentDto){
        if(patentDto == null){
            return "patent_form";
        }

        patentDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));

        //封装完成，插入数据。
        researchService.savePatent(patentDto);

        return "redirect:/research/patent";
    }

    @RequestMapping(value = "deletePatent")
    public String deletePatentById(Long id){
        researchService.deletePatentById(id);
        return "redirect:/research/patent";
    }

    @RequestMapping(value = "editPatent")
    public String editPatentById(Long id,PatentDto patentDto){
        patentDto.setId(id);
        researchService.updatePatentById(patentDto);
        return "redirect:/research/patent";
    }

    /**
     * 模糊查询
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "searchPatent",method = RequestMethod.POST)
    public String searchPatent(String keyword, Model model){
        List<Patent> patents = researchService.searchPatent(keyword);
        model.addAttribute("patents",patents);
        return "research_patent";
    }

    /**
     *所有Project对外接口
     */
    @RequestMapping(value = "project")
    public String getProjects(HttpServletRequest httpServletRequest,Model model){
        String email = EmailUtils.getUserEmail(httpServletRequest);
        List<Project> projects = researchService.getProjects(email);
        model.addAttribute("projects",projects);
        return "research_project";
    }

    @RequestMapping(value = "formProject",method = RequestMethod.GET)
    public String formProject(Long id,Model model){
        if (id != null){
            Project project = researchService.getProjectById(id);
            model.addAttribute("project",project);
        }
        return "project_form";
    }

    @RequestMapping(value = "saveProject",method = RequestMethod.POST)
    public String saveProject(HttpServletRequest httpServletRequest, ProjectDto projectDto){
        if(projectDto == null){
            return "project_form";
        }

        projectDto.setEmail(EmailUtils.getUserEmail(httpServletRequest));

        //封装完成，插入数据。
        researchService.saveProject(projectDto);

        return "redirect:/research/project";
    }

    @RequestMapping(value = "deleteProject")
    public String deleteProjectById(Long id){
        System.out.println(id);
        researchService.deleteProjectById(id);
        return "redirect:/research/project";
    }

    @RequestMapping(value = "editProject")
    public String editProjectById(Long id,ProjectDto projectDto){
        projectDto.setId(id);
        researchService.updateProjectById(projectDto);
        return "redirect:/research/project";
    }

    /**
     * 模糊查询
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "searchProject",method = RequestMethod.POST)
    public String searchProject(String keyword, Model model){
        List<Project> projects = researchService.searchProject(keyword);
        model.addAttribute("projects",projects);
        return "research_project";
    }
}
