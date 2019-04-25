package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperDao {
    List<Paper> getPapers(String email);
    Paper getPaperById(long id);
    void deletePaperById(long id);
    void savePaper(Paper paper);
    void updatePaper(Paper paper);
    List<Paper> searchPaper(Paper paper);
}
