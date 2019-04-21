package com.cqupt.ysc.graduation.project.web.admin.service;

import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Paper;

import java.util.List;

/**
 * 论文管理服务
 */
public interface ResearchService {
    List<Paper> getPapers(String email);
    Paper getPaperById(long id);
    void deletePaperById(long id);
    String savePaper(PaperDto paperDto);
}
