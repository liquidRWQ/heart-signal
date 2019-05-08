package com.company.heartbeatsignal.task;

import com.company.heartbeatsignal.config.HeartAppConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Liquid
 * @类名： TokenTimer
 * @描述：
 * @date 2019/3/28
 */
@Slf4j
public class TokenTimer {
    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("token-schedule-pool-%d").daemon(true).build());

    public static void start() {
        executorService.scheduleAtFixedRate(() -> {

            HeartAppConfig.accessToken = null;
            HeartAppConfig.enterpriseWeChatAccessToken = null;

            log.info("获取access_token成功，有效时长{}秒 token:{}", HeartAppConfig.ACCESS_TOKEN_EFFECTIVE_SECOND, HeartAppConfig.enterpriseWeChatAccessToken);

        }, 0, HeartAppConfig.ACCESS_TOKEN_EFFECTIVE_SECOND - 200, TimeUnit.SECONDS);
    }

}
