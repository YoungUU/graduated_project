package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Reward implements Serializable {
    private long id;
    private Date getime;
    private String context;
    private String reward_name;
    private String level;
    private short delFlg;
    private String email;
    private Date created;
    private Date updated;
}
