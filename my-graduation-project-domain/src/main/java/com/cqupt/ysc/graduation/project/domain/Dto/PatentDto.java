package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PatentDto implements Serializable {
    private String patentName;
    private String patentNumber;
    private String author;
    private short delFlg;
    private String email;
}
