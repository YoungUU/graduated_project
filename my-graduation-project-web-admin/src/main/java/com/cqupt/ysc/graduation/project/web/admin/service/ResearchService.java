package com.cqupt.ysc.graduation.project.web.admin.service;

import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Dto.PatentDto;
import com.cqupt.ysc.graduation.project.domain.Dto.ProjectDto;
import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.domain.Patent;
import com.cqupt.ysc.graduation.project.domain.Project;

import java.util.List;

/**
 * 科学研究管理
 */
public interface ResearchService {
    //论文管理
    List<Paper> getPapers(String email);
    Paper getPaperById(long id);
    void deletePaperById(long id);
    String savePaper(PaperDto paperDto);
    void updatePaperById(PaperDto paperDto);
    List<Paper> searchPaper(String keyword);

    //专利管理
    List<Patent> getPatents(String email);
    Patent getPatentById(long id);
    void deletePatentById(long id);
    String savePatent(PatentDto patentDto);
    void updatePatentById(PatentDto patentDto);

    //研究项目管理
    List<Project> getProjects(String email);
    Project getProjectById(long id);
    void deleteProjectById(long id);
    String saveProject(ProjectDto projectDto);
    void updateProjectById(ProjectDto projectDto);
}
