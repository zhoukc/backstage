package com.newmind.seobackstage.common.utils;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class UUIDUtil {

    public static String getUUID32() {
        String str = UUID.randomUUID().toString();
        return StringUtils.delete(str, "-");
    }

    public static String getUUID36() {
        return UUID.randomUUID().toString();
    }
}
