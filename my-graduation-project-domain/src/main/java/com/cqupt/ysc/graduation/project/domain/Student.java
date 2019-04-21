package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private long id;
    private int stuNum;//学号
    private String stuGrade;
    private int stuNumber;//学生排名
    private String stuPhone;
    private short delFlg;
    private String email;
    private Date created;
    private Date updated;
}
