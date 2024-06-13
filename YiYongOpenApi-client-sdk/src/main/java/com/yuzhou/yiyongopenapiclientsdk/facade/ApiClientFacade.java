package com.yuzhou.yiyongopenapiclientsdk.facade;

import com.yuzhou.yiyongopenapiclientsdk.factory.ApiClientFactory;
import com.yuzhou.yiyongopenapiclientsdk.model.HttpMethod;
import com.yuzhou.yiyongopenapiclientsdk.client.ApiClient;

import java.util.HashMap;
import java.util.Map;

/**
 * api客户端门面类
 * 封装调用逻辑
 *
 * @author yuzhou
 * @version 1.0
 */
public class ApiClientFacade {
    private final Map<String, ApiClient> clientMap;


    /**
     * 创建默认网关URL的客户端门面对象
     *
     * @param accessKey the access key
     * @param secretKey the secret key
     */
    public ApiClientFacade(String accessKey, String secretKey) {
        //初始化客户端
        ApiClientFactory factory = new ApiClientFactory(accessKey, secretKey);
        ApiClient getClient = factory.createClient(HttpMethod.GET);
        ApiClient postClient = factory.createClient(HttpMethod.POST);
        ApiClient putClient = factory.createClient(HttpMethod.PUT);
        ApiClient deleteClient = factory.createClient(HttpMethod.DELETE);
        this.clientMap = new HashMap<>();
        this.clientMap.put(HttpMethod.GET.getValue(),getClient);
        this.clientMap.put(HttpMethod.POST.getValue(),postClient);
        this.clientMap.put(HttpMethod.PUT.getValue(),putClient);
        this.clientMap.put(HttpMethod.DELETE.getValue(),deleteClient);
    }

    /**
     * 根据传入的gatewayHost创建客户端门面对象
     *
     * @param accessKey   the access key
     * @param secretKey   the secret key
     * @param gatewayHost the gateway host
     */
    public ApiClientFacade(String accessKey, String secretKey, String gatewayHost) {
        //初始化客户端
        ApiClientFactory factory = new ApiClientFactory(accessKey, secretKey, gatewayHost);
        ApiClient getClient = factory.createClient(HttpMethod.GET);
        ApiClient postClient = factory.createClient(HttpMethod.POST);
        ApiClient putClient = factory.createClient(HttpMethod.PUT);
        ApiClient deleteClient = factory.createClient(HttpMethod.DELETE);
        this.clientMap = new HashMap<>();
        this.clientMap.put(HttpMethod.GET.getValue(),getClient);
        this.clientMap.put(HttpMethod.POST.getValue(),postClient);
        this.clientMap.put(HttpMethod.PUT.getValue(),putClient);
        this.clientMap.put(HttpMethod.DELETE.getValue(),deleteClient);
    }

    /**
     * 代替用户真正执行请求的方法
     *
     * @param method   the method
     * @param uri      the uri
     * @param paramMap the param map
     * @return the string
     */
    public String invoke(String method, String uri, Map<String, Object> paramMap) {
        method = method.toUpperCase();
        ApiClient client = clientMap.get(method);
        return client.invoke(uri, paramMap);
    }
}
