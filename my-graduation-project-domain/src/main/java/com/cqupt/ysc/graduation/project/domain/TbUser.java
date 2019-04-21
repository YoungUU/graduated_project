package com.cqupt.ysc.graduation.project.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbUser implements Serializable {
    private long id;
    private String username;
    private String password;
    private String phone;
    private short delFlg;
    private String email;
    private Date created;
    private Date updated;

}
