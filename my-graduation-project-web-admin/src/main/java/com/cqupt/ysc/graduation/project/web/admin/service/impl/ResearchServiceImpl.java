package com.cqupt.ysc.graduation.project.web.admin.service.impl;

import com.cqupt.ysc.graduation.project.commons.constant.TimeUtils;
import com.cqupt.ysc.graduation.project.domain.Dto.PaperDto;
import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.web.admin.dao.PaperDao;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class ResearchServiceImpl implements ResearchService {

    @Autowired
    private PaperDao paperDao;

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
            paperDao.insertPaper(paper);
        }

        //编辑用户
        else {

        }

        return "插入成功";
    }
}
