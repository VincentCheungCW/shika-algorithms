package com.shika.限流算法;


import java.util.concurrent.ArrayBlockingQueue;

public class TokenBucket2 {
    private ArrayBlockingQueue<Token> bucket;
    private int capacity; // 桶的容量
    private long rate; // 产生令牌的速率，单位：毫秒

    class Token {
    }

    public TokenBucket2(int capacity, long rate) {
        this.bucket = new ArrayBlockingQueue<>(capacity);
        this.capacity = capacity;
        this.rate = rate;
        Thread thread = new Thread(this::produceToken);
        thread.start();
    }

    // 处理请求
    public boolean processRequest() {
        Token token = bucket.poll();
        if (token != null) {
            return true;
        } else {
            return false;
        }
    }

    // 产生令牌
    private void produceToken() {
        while (true) {
            if (bucket.size() < capacity) {
                bucket.add(new Token());
            }
            try {
                Thread.sleep(rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 桶的容量为5，产生令牌的速率为1000毫秒/个
        TokenBucket2 tokenBucket =
                new TokenBucket2(5, 1000);
        Thread.sleep(10000);

        // 模拟10个请求
        for (int i = 1; i <= 10; i++) {
            if (tokenBucket.processRequest()) {
                System.out.println("Request " + i + " processed.");
            } else {
                System.out.println("Request " + i + " rejected.");
            }
        }
    }
}