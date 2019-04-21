package com.cqupt.ysc.graduation.project.web.admin.service.test;

import com.cqupt.ysc.graduation.project.domain.Paper;
import com.cqupt.ysc.graduation.project.web.admin.service.ResearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class PaperServiceTest {
    @Autowired
    private ResearchService paperService;

    @Test
    public void testGetPapers(){
        List<Paper> papers = paperService.getPapers("admin@cqupt.com");
        System.out.println(papers);
    }

    @Test
    public void testGetPaperById(){
        Paper paper = paperService.getPaperById(2);
        System.out.println(paper.toString());
    }

    @Test
    public void testDeleteById(){
        paperService.deletePaperById(2);
    }
}
