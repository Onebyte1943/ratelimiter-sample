package com.onebyte.painter.limiter;

import com.open.onebyte.ratelimiter.annotation.EnableRedisRateLimiter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuntai
 */
@EnableRedisRateLimiter
@SpringBootApplication
public class RateLimiterSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimiterSampleApplication.class, args);
    }

}
