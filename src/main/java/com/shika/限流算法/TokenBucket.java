package com.shika.限流算法;

/**
 * TokenBucket 类表示一个令牌桶
 * 实践中令牌桶容量和令牌生成速率可设置为可配置参数
 * 优点：
 * 1. 可以处理突发流量：当桶满时，能够以最大速度处理请求。这对于需要处理突发流量的应用场景非常有用；
 * 2. 限制平均速率：在长期运行中，数据的传输率会被限制在预定义的平均速率（即生成令牌的速率）；
 * 3. 灵活性：与漏桶算法相比，令牌桶算法提供了更大的灵活性。例如，可以动态地调整生成令牌的速率；
 * 缺点：令牌桶需要一定的存储空间来保存令牌
 * Guava的RateLimiter限流组件，就是基于令牌桶算法实现的。
 */
public class TokenBucket {

    private final int capacity;     // 令牌桶容量
    private final int rate;         // 令牌生成速率，单位：令牌/秒
    private int tokens;             // 当前令牌数量
    private long lastRefillTimestamp;  // 上次令牌生成时间戳

    /**
     * 构造函数中传入令牌桶的容量和令牌生成速率。
     *
     * @param capacity
     * @param rate
     */
    public TokenBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
        this.tokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    /**
     * acquire() 方法表示一个请求是否允许通过，
     * 该方法使用 synchronized 关键字进行同步，以保证线程安全。
     * (也可以考虑变量定义为ThreadLocal)
     *
     * @return
     */
    public synchronized boolean acquire() {
        checkToken();
        if (tokens > 0) {
            tokens--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * checkToken() 方法用于检查令牌，生成令牌
     * tokens 变量表示当前令牌数量，
     * lastRefillTimestamp 变量表示上次令牌生成的时间戳。
     */
    private void checkToken() {
        long now = System.currentTimeMillis();
        if (now > lastRefillTimestamp) {
            int generatedTokens = (int) ((now - lastRefillTimestamp) / 1000 * rate);
            tokens = Math.min(tokens + generatedTokens, capacity);
            lastRefillTimestamp = now;
        }
    }
}