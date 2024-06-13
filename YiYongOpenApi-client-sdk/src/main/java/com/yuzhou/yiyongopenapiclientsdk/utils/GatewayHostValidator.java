package com.yuzhou.yiyongopenapiclientsdk.utils;

import java.util.regex.Pattern;

/**
 * 网关URL路径校验
 *
 * @author yuzhou
 * @version 1.0
 */
public class GatewayHostValidator {

    private static final String HTTP_PATTERN = "^http://([a-zA-Z0-9.-]+(:\\d+)?|\\d+\\.\\d+\\.\\d+\\.\\d+(:\\d+)?)$";
    private static final String HTTPS_PATTERN = "^https://([a-zA-Z0-9.-]+(:\\d+)?|\\d+\\.\\d+\\.\\d+\\.\\d+(:\\d+)?)$";

    public static boolean isValidGatewayHost(String gatewayHost) {
        return Pattern.matches(HTTP_PATTERN, gatewayHost) || Pattern.matches(HTTPS_PATTERN, gatewayHost);
    }
}
