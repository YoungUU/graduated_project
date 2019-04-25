package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Project implements Serializable {
    private Long id;
    private String projectName;
    private String mainPerson;
    private String context;
    private String scale;
    private short delFlg;
    private String email;
    private Date created;
    private Date updated;
}
