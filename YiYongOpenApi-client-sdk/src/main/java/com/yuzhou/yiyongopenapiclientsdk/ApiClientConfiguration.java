package com.yuzhou.yiyongopenapiclientsdk;

import cn.hutool.core.util.StrUtil;
import com.yuzhou.yiyongopenapiclientsdk.facade.ApiClientFacade;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuzhou
 * @version 1.0
 */
@Configuration
@ComponentScan
@ConfigurationProperties("web-open-api.client")
@Data
public class ApiClientConfiguration {
    private String accessKey;
    private String secretKey;
    private String gatewayHost;

    @Bean
    public ApiClientFacade webApiClient() {
        return StrUtil.isBlank(gatewayHost)
                ? new ApiClientFacade(accessKey,secretKey)
                : new ApiClientFacade(accessKey, secretKey, gatewayHost);
    }

}
