package com.omartahri.ex3.controller;

import com.omartahri.ex3.entity.PageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class EventPageController {

    private static final Logger logger = LoggerFactory.getLogger(EventPageController.class);

    private final StreamBridge streamBridge;

    public EventPageController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent generatePageEvent(@PathVariable String topic, @PathVariable String name) {
        String user = Math.random() > 0.5 ? "omar" : "otari";
        PageEvent pageEvent = new PageEvent(name, user, new Date(), new Random().nextInt(1000));

        logger.info("Publishing PageEvent to topic: {}", topic);
        logger.info("PageEvent: {}", pageEvent);
        logger.info("-------------------------------");

        streamBridge.send(topic, pageEvent);

        return pageEvent;
    }
}
