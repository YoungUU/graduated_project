package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RewardDto implements Serializable {
    private Date getime;
    private String context;
    private String reward_name;
    private String level;
    private short delFlg;
    private String email;
}
