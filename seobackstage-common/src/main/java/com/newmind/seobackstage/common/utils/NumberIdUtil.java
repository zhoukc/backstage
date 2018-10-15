package com.newmind.seobackstage.common.utils;

import java.util.UUID;

public class NumberIdUtil {

    public static String getOrderIdByUUId() {
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        //0 代表前面补充0
        //16 代表长度为16
        //d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    public static String getTradeNumberByUUId() {
        int machineId = 2;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        return machineId + String.format("%017d", hashCodeV);
    }
}
