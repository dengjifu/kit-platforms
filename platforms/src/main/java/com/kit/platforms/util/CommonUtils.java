package com.kit.platforms.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luxin on 2016/8/23.
 * 一些通用的方法
 */

public class CommonUtils {
    //判断一个对象是否为空
    public static boolean isEmpty(Object obj){
        if(obj == null || obj.equals("")){
            return  true;
        }
            return  false;
    }

    public static boolean isNotEmpty(Object obj){
        return  !isEmpty(obj);
    }

    /**
    *将json格式转换成字符串
    *input:"{\"success\":true}"
     * *output:[{"sucess":true}]
    */
    public  static String doJson2Str(String jsonStr){
        String resultMsg ="";
        JSONArray jsonArray = new JSONArray();
        JSONObject currentObj = JSONObject.fromObject(jsonStr);
        jsonArray.add(currentObj);
        resultMsg = jsonArray.toString();
        return resultMsg;
    }

    /**
     *将对象的属性和值用map的形式保存
     */
    public static HashMap obj2map(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        HashMap map = new HashMap();
        BeanInfo beanInfo =  Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (!key.equals("class")) {
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                map.put(key, value);
            }
        }
        return map;
    }

    //将map中的值转换成字符串
    public static String mapValue2String(Map map, String name){
        return map.get(name) == null ? "" : map.get(name).toString();
    }

    //将map中的值转换成数字
    public static int mapValue2Int(Map map, String name){
        return map.get(name) == null ? 0 : Integer.parseInt(map.get(name).toString());
    }
}
