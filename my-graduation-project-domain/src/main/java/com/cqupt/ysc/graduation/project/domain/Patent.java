package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Patent implements Serializable {
    private long id;
    private String patentName;
    private String patentNumber;
    private String author;
    private short delFlg;
    private String email;
    private Date created;
    private Date updated;
}
