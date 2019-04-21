package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectDto implements Serializable {
    private String projectName;
    private String mainPerson;
    private String context;
    private String scale;
    private short delFlg;
    private String email;
}
