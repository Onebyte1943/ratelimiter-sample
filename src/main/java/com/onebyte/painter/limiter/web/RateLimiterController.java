package com.onebyte.painter.limiter.web;

import com.open.onebyte.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangqk
 */
@RestController
@RequestMapping("/rate/limiter")
public class RateLimiterController {


    @RateLimiter(resources = "#param.patId", instances = "leaky")
    @PostMapping("/echo")
    public Param echo(@RequestBody Param param) {
        System.out.println("echo---------------------");
        return param;
    }


    public static class Param {
        private Long patId;
        private String cardNo;

        public Long getPatId() {
            return patId;
        }

        public void setPatId(Long patId) {
            this.patId = patId;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }
    }
}
