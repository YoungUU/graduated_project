package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentDto implements Serializable {
    private int stuNum;//学号
    private String stuGrade;
    private int stuNumber;//学生排名
    private String stuPhone;
    private short delFlg;
    private String email;
}
