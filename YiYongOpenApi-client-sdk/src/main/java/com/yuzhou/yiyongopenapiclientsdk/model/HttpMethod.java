package com.yuzhou.yiyongopenapiclientsdk.model;

/**
 * @author yuzhou
 * @version 1.0
 */
public enum HttpMethod {
    /**
     * 请求类型
     */
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    /**
     * 请求类型值
     */
    private String value;

    public String getValue() {
        return value;
    }

    HttpMethod(String value) {
        this.value = value;
    }
}
