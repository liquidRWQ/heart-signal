package com.company.heartbeatsignal.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liquid
 * @类名： RepairAppConfig
 * @描述：
 * @date 2018/12/29
 */
@Slf4j
@Configuration
public class RepairAppConfig {

    public static final String GRANT_TYPE = "client_credential";


    public static String accessToken = "";

    public static String publicAccessToken = "";

    public static String enterpriseWeChatAccessToken = "";

    public static final Integer ACCESS_TOKEN_EFFECTIVE_SECOND = 7200;

    public static String[] managerPublicOpenIds = new String[10];

    public static int managerCount;

    public static final String APP_ID = "wx2e7304608fad59e6";

    public static final String SECRET = "a252d489ba3c249c73dc4a7b947bd64e";

    public static final String PUBLIC_APP_ID = "wx1a6a3a4287fb49e3";

    public static final String PUBLIC_SECRET = "875fd460bbd12a556cd4a94537aff6aa";

    public static final String ENTERPRISE_WE_CHAT_APP_ID = "ww069a1e0d963addb1";

    public static final String ENTERPRISE_WE_CHAT_SECRET = "ZZ5ePF52V5Zym33Zzp27sGgX8RmFAKzNZvhbisdQDps";



}
