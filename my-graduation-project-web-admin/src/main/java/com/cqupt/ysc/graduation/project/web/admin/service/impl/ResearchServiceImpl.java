package com.cqupt.ysc.graduation.project.web.admin.service.impl;

import com.cqupt.ysc.graduation.project.commons.constant.TimeUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Dto.PatentDto;
import com.cqupt.ysc.graduation.project.domain.Dto.ProjectDto;
import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.domain.Patent;
import com.cqupt.ysc.graduation.project.domain.Project;
import com.cqupt.ysc.graduation.project.web.admin.dao.PaperDao;
import com.cqupt.ysc.graduation.project.web.admin.dao.PatentDao;
import com.cqupt.ysc.graduation.project.web.admin.dao.ProjectDao;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Autowired
    private PaperDao paperDao;

    @Autowired
    private PatentDao patentDao;

    @Autowired
    private ProjectDao projectDao;


    /**
     *Paper所有操作
     */
    @Override
    public List<Paper> getPapers(String email) {
        return paperDao.getPapers(email);
    }

    @Override
    public Paper getPaperById(long id) {
        return paperDao.getPaperById(id);
    }

    @Override
    public void deletePaperById(long id) {
        paperDao.deletePaperById(id);
    }

    @Override
    public String savePaper(PaperDto paperDto) {
        if (paperDto == null){
            return "paper_form";
        }
        paperDto.setUpdated(TimeUtils.getSystemTime());
        //新增用户
        if (paperDto.getId() == null){
            Paper paper = new Paper();
            BeanUtils.copyProperties(paperDto,paper);
            paper.setCreated(TimeUtils.getSystemTime());
            paperDao.savePaper(paper);
        }
        return "插入成功";
    }

    @Override
    public void updatePaperById(PaperDto paperDto) {
        Paper paper = new Paper();
        BeanUtils.copyProperties(paperDto,paper);
        paper.setUpdated(TimeUtils.getSystemTime());
        System.out.println(paper.toString());
        paperDao.updatePaper(paper);
    }

    @Override
    public List<Paper> searchPaper(String keyword) {
        Paper paper = new Paper();
        paper.setAuthor(keyword);
        paper.setPaperName(keyword);
        paper.setStatus(keyword);
        return paperDao.searchPaper(paper);
    }

    /**
     *Patent所有操作
     */
    @Override
    public List<Patent> getPatents(String email) {
        return patentDao.getPatent(email);
    }

    @Override
    public Patent getPatentById(long id) {
        return patentDao.getPatentById(id);
    }

    @Override
    public void deletePatentById(long id) {
        patentDao.deletePatentById(id);
    }

    @Override
    public String savePatent(PatentDto patentDto) {
        if (patentDto == null){
            return "patent_form";
        }
        //新增用户
        if (patentDto.getId() == null){
            Patent patent = new Patent();
            BeanUtils.copyProperties(patentDto,patent);
            patent.setUpdated(TimeUtils.getSystemTime());
            patent.setCreated(TimeUtils.getSystemTime());
            patentDao.savePatent(patent);
        }
        return "插入成功";
    }

    @Override
    public void updatePatentById(PatentDto patentDto) {
        Patent patent = new Patent();
        BeanUtils.copyProperties(patentDto,patent);
        patent.setUpdated(TimeUtils.getSystemTime());
        patentDao.updatePatentById(patent);
    }

    @Override
    public List<Patent> searchPatent(String keyword) {
        Patent patent = new Patent();
        patent.setAuthor(keyword);
        patent.setPatentName(keyword);
        return patentDao.searchPatent(patent);
    }

    /**
     *Project所有操作
     */
    @Override
    public List<Project> getProjects(String email) {
        return projectDao.getProject(email);
    }

    @Override
    public Project getProjectById(long id) {
        return projectDao.getProjectById(id);
    }

    @Override
    public void deleteProjectById(long id) {
        projectDao.deleteProjectById(id);
    }

    @Override
    public String saveProject(ProjectDto projectDto) {
        if (projectDto == null){
            return "project_form";
        }
        //新增用户
        if (projectDto.getId() == null){
            Project project = new Project();
            BeanUtils.copyProperties(projectDto,project);
            project.setUpdated(TimeUtils.getSystemTime());
            project.setCreated(TimeUtils.getSystemTime());
            projectDao.saveProject(project);
        }
        return "插入成功";
    }

    @Override
    public void updateProjectById(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto,project);
        project.setUpdated(TimeUtils.getSystemTime());
        projectDao.updateProjectById(project);
    }

    @Override
    public List<Project> searchProject(String keyword) {
        Project project = new Project();
        project.setMainPerson(keyword);
        project.setProjectName(keyword);
        return projectDao.searchProject(project);
    }
}
