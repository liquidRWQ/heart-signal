package com.company.heartbeatsignal.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Liquid
 * @类名： ThreadPool
 * @描述：
 * @date 2019/4/17
 */
public class ThreadPool {

    private ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("Thread-pool-%d").build();
    private ExecutorService singleThreadPool = new ThreadPoolExecutor(20, 100,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

}
