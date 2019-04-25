package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
    private long id;
    private String username;
    private String email;
    private String namePinyin;
    private String englishName;
    private String pic;
    private String password;
    private Integer gender;
    private String phone;
    private String graduatedSchool;
    private String education;
    private String academicDegree;
    private String incumbencyInformation;
    private String company;
    private String position1;
    private String mainPosts;
    private String otherPosts;
    private String extend1;
    private String extend2;
    private String extend3;
    private String extend4;
    private Date created;
    private Date updated;


}
