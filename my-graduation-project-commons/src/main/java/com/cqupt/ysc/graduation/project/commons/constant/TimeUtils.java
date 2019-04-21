package com.cqupt.ysc.graduation.project.commons.constant;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static Date getSystemTime(){
        Date date = new Date();//获得系统时间
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp trueTime = Timestamp.valueOf(nowTime);
        return trueTime;
    }
}
