package com.cqupt.ysc.graduation.project.commons.constant;

public class UrlUtils {
    public static String getTureUrl(String url){
        String[] parts = url.split("/");
        String trueUrl = parts[2];
        return trueUrl;
    }
}
