package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Reward implements Serializable {
    private Long id;
    private String getime;
    private String context;
    private String rewardName;
    private String level;
    private short delFlg;
    private String email;
    private Date created;
    private Date updated;
}
