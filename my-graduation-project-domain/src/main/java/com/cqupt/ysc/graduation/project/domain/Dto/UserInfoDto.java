package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoDto implements Serializable {
    private String username;
    private String email;
    private String password;
    private String namePinyin;
    private String englishName;
    private String pic;
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
}
