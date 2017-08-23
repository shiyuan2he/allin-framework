package com.hsy.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.thread.pool
 * @date 23/08/2017 5:01 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class FixedThreadPool {

    private final ExecutorService fixedThreadPool;

    public FixedThreadPool(int threadPoolNum) {
        this.fixedThreadPool = Executors.newFixedThreadPool(threadPoolNum,new ThreadFactory() {
            AtomicInteger atomic = new AtomicInteger();
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "fixedThreadPool-" + this.atomic.getAndIncrement());
            }
        });
    }

    public ExecutorService getFixedThreadPool() {
        return fixedThreadPool;
    }
}
