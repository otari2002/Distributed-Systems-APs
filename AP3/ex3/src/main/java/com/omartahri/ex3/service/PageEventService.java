package com.omartahri.ex3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.omartahri.ex3.entity.PageEvent;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {

    private static final Logger logger = LoggerFactory.getLogger(PageEventService.class);

    private final StreamBridge streamBridge;

    public PageEventService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Bean
    public Consumer<PageEvent> pageEventConsumer() {
        return (input) -> {
            logger.info("PageEvent: {}", input.toString());
            logger.info("-------------------------------");
        };
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier() {
        String[] pages = {"P1", "P2"};
        String[] users = {"random", "omar", "otari"};
        return () -> new PageEvent(
                pages[new Random().nextInt(pages.length)],
                users[new Random().nextInt(users.length)],
                new Date(),
                new Random().nextInt(9000)
        );
    }

    @Bean
    public Function<PageEvent, PageEvent> pageEventFunction() {
        return (input) -> {
            if ("P3".equals(input.getPage())) {
                input.setName("SpecialUser");
            }
            input.setPage("50");
            return input;
        };
    }
}
