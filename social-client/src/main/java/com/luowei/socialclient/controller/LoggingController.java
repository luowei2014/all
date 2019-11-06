package com.luowei.socialclient.controller;

import com.luowei.socialclient.mq.producer.TestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    @Autowired
    private TestProducer testProducer;

    @RequestMapping("/sendMsg")
    public String sendFanout() {
        testProducer.send("test_queue");
        return "success";
    }
}
