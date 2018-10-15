package com.newmind.seobackstage.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description 数据装填
 * create by zhoukc
 */
public class BeanUtil {

    public static void populate(Object source, Map<String, Object> target) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass(), Object.class);
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : descriptors) {
            String key = property.getName();
            Method readMethod = property.getReadMethod();
            Object value = readMethod.invoke(source);
            target.put(key, value);
        }
    }
}
