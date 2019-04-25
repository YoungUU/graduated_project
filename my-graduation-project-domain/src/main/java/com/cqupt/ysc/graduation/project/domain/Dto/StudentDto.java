package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StudentDto implements Serializable {
    private Long id;
    private String stuName;
    private Integer stuNum;//学号
    private String stuGrade;
    private Integer stuNumber;//学生排名
    private String stuPhone;
    private short delFlg;
    private Date updated;
    private String email;
}
