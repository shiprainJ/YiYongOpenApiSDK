package com.yuzhou.yiyongopenapiclientsdk.client;

import java.util.HashMap;
import java.util.Map;

import static com.yuzhou.yiyongopenapiclientsdk.utils.SignUtil.genSign;

/**
 * 默认的抽象客户端类
 *
 * @author yuzhou
 * @version 1.0
 */
public abstract class DefaultAbstractApiClient implements ApiClient {
    private final String accessKey;

    private final String secretKey;

    protected final String gatewayHost;

    public DefaultAbstractApiClient(String accessKey, String secretKey, String gatewayHost) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.gatewayHost = gatewayHost;
    }

    protected Map<String,String> getApiHeaderMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("requestSource","webopenapi-sdk");
        map.put("accessKey",accessKey);
        //时间戳
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        map.put("timestamp",timestamp);
        //签名认证
        map.put("sign",genSign(timestamp,secretKey));
        return map;
    }
}
