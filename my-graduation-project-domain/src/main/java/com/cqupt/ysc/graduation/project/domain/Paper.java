package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Paper implements Serializable,Comparable<Paper>{

    private Long id;
    private String paperName;
    private String number1;
    private String url;
    private String releaseTime;
    private Integer ordernum;
    private String status;
    private String author;
    private String source;
    private String email;
    private short delFlg;
    private Date created;
    private Date updated;

    @Override
    public int compareTo(Paper o) {
        if (this.ordernum < o.getOrdernum()){
            return 1;
        }else return -1;
    }
}
