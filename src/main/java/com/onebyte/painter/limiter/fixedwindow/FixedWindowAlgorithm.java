package com.onebyte.painter.limiter.fixedwindow;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 固定窗口算法Java单机实现
 *
 * @author yangqk
 */
@Slf4j
public class FixedWindowAlgorithm {

    /**
     * 开始时间
     */
    private static long startTime = System.currentTimeMillis();

    /**
     * 允许通过的个数
     */
    private static final long maxCount = 2;

    /**
     * 窗口统计的周期，窗口的大小
     */
    private static final long period = 1000;

    /**
     * 窗口计数器
     */
    private static final AtomicLong counter = new AtomicLong();


    /**
     * 是否允许通过，若未被限流，则返回true
     *
     * @return the boolean
     */
    public static boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        // 在当前时间周期内
        if (currentTime <= startTime + period) {
            long count = counter.incrementAndGet();
            return count < maxCount;
        } else {
            // 不在当前时间周期内
            log.info("A new window: {}", LocalDateTime.now());
            synchronized (FixedWindowAlgorithm.class) {
                if (currentTime > startTime + period) {
                    counter.set(0);
                    startTime = currentTime;
                }
            }
            return true;
        }
    }
}
