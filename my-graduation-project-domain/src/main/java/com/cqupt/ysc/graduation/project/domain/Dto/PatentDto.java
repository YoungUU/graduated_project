package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PatentDto implements Serializable {
    private Long id;
    private String patentName;
    private String patentNumber;
    private String author;
    private short delFlg;
    private Date updated;
    private String email;
}
