package com.cqupt.ysc.graduation.project.domain.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RewardDto implements Serializable {
    private Long id;
    private String getime;
    private String context;
    private String rewardName;
    private String level;
    private short delFlg;
    private Date updated;
    private String email;
}
