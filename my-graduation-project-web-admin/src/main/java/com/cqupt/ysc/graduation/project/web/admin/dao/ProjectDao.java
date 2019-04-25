package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDao {

    List<Project> getProject(String email);
    Project getProjectById(long id);
    void deleteProjectById(long id);
    void saveProject(Project project);
    void updateProjectById(Project project);
}
