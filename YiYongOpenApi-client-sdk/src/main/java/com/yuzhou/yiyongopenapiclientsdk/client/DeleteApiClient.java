package com.yuzhou.yiyongopenapiclientsdk.client;

import cn.hutool.http.HttpRequest;
import com.yuzhou.yiyongopenapiclientsdk.utils.RestfulUtil;

import java.util.Map;

/**
 * @author yuzhou
 * @version 1.0
 */
public class DeleteApiClient extends DefaultAbstractApiClient {
    public DeleteApiClient(String accessKey, String secretKey, String gatewayHost) {
        super(accessKey, secretKey, gatewayHost);
    }

    @Override
    public String invoke(String uri, Map<String, Object> paramMap) {
        //判断是否是restful风格的请求，请求不同，参数拼接方式也不一样
        String tempUri = uri;
        uri = RestfulUtil.buildUri(uri,paramMap);
        String url = gatewayHost + uri;
        return HttpRequest.delete(url)
                .header("uri",tempUri)
                .addHeaders(getApiHeaderMap())
                .contentType("application/json;charset=UTF-8")
                .timeout(50000)
                .execute().body();
    }
}
