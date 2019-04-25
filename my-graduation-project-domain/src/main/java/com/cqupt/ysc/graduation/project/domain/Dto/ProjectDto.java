package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProjectDto implements Serializable {
    private Long id;
    private String projectName;
    private String mainPerson;
    private String context;
    private String scale;
    private short delFlg;
    private Date updated;
    private String email;
}
