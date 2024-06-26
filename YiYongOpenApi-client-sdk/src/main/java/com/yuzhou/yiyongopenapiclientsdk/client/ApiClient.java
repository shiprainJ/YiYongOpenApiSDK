package com.yuzhou.yiyongopenapiclientsdk.client;

import java.util.Map;

/**
 * 接口调用客户端上层接口
 *
 * @author yuzhou
 * @version 1.0
 */
public interface ApiClient {
    /**
     * 发送请求调用方法
     * @param uri 被调用接口的uri路径
     * @param paramMap map形式的接口参数
     * @return 返回调用结果
     */
    String invoke(String uri, Map<String, Object> paramMap);
}
