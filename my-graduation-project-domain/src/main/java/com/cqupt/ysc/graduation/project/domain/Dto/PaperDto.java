package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PaperDto implements Serializable {
    private Long id;
    private String paperName;
    private String number1;
    private String url;
    private String releaseTime;
    private int ordernum;
    private String status;
    private String author;
    private String source;
    private String email;
    private Date updated;
    private short delFlg;
}
