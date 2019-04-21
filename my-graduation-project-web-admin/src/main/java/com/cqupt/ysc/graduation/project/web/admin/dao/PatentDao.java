package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.Patent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatentDao {

    List<Patent> getPatent(String email);
    Patent getPatentById(long id);
    void deletePatentById(long id);
    void savePatent(Patent patent);

}
