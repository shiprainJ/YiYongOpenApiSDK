package com.yuzhou.yiyongopenapiclientsdk.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * The type Json util.
 *
 * @author yuzhou
 * @version 1.0
 */
public class JsonUtil {
    private static Gson gson;

    static {
        gson = new Gson();
    }

    /**
     * To param map map.
     *
     * @param requestParam the request param
     * @return the map
     */
    public static Map<String, Object> toMap(String requestParam) {
        Map<String, Object> paramMap;
        try {
            // 使用Gson库将JSON字符串转换为Map
            paramMap = gson.fromJson(requestParam,
                    new TypeToken<Map<String, Object>>() {}.getType());
        } catch (Exception e) {
            throw new RuntimeException("JSON转Map失败",e);
        }
        return paramMap;
    }

}
