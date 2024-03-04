package com.shika.限流算法;

import com.google.common.util.concurrent.RateLimiter;

public class FixedWindows {

    public static Integer counter = 0;  //统计请求数
    public static long lastAcquireTime = 0L;
    public static final Long windowUnit = 1000L; //假设固定时间窗口是1000ms
    public static final Integer threshold = 10; // 窗口阀值是10

    /**
     * 固定窗口算法
     * 优点：简单，易于实现和理解。
     * 缺点：存在临界问题，比如: 假设限流阀值为 5个请求，单位时间窗口是 1s,
     * 如果我们在单位时间内的 前0.8-1s和 1-1.2s，
     * 分别并发5个请求。虽然都没有超过阀值，但是如果算0.8-1.2s,则并发数高达10，
     * 已经超过单位时间1s不超过5阀值的定义啦。
     *
     * @return
     */
    public synchronized boolean fixedWindowsTryAcquire() {
        long currentTime = System.currentTimeMillis();  //获取系统当前时间
        if (currentTime - lastAcquireTime > windowUnit) {  //检查是否在时间窗口内
            counter = 0;  // 计数器清0
            lastAcquireTime = currentTime;  //开启新的时间窗口
        }
        if (counter < threshold) {  // 小于阀值
            counter++;  //计数统计器加1
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // guava库的RateLimiter，采用令牌桶实现
        RateLimiter rateLimiter = RateLimiter.create(100);
        double acquire = rateLimiter.acquire();
    }
}
