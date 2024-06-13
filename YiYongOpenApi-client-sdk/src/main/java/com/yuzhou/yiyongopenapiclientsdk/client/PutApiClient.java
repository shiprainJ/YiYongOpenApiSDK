package com.yuzhou.yiyongopenapiclientsdk.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;

import java.util.Map;

/**
 * @author yuzhou
 * @version 1.0
 */
public class PutApiClient extends DefaultAbstractApiClient {
    public PutApiClient(String accessKey, String secretKey, String gatewayHost) {
        super(accessKey, secretKey, gatewayHost);
    }

    @Override
    public String invoke(String uri, Map<String, Object> paramMap) {
        String url = gatewayHost + uri;
        String body = JSONUtil.toJsonStr(paramMap);
        return HttpRequest.put(url)
                .header("uri",uri)
                .addHeaders(getApiHeaderMap())
                .contentType("application/json;charset=UTF-8")
                .body(body)
                .timeout(50000)
                .execute().body();
    }
}
