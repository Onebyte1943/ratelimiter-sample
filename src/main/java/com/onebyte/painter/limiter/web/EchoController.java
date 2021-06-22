package com.onebyte.painter.limiter.web;

import com.onebyte.painter.limiter.fixedwindow.FixedWindowAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuntai
 */
@RestController
public class EchoController {

    @GetMapping("/fixedWindowAlgorithm")
    public String fixedWindowAlgorithm() {
        boolean acquire = FixedWindowAlgorithm.tryAcquire();
        if (!acquire) {
            return "blocked!";
        }
        return "hello, world!";
    }
}
