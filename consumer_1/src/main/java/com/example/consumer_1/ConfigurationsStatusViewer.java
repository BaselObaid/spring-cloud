package com.example.consumer_1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @RefreshScope
 ** It is commonly used in conjunction with Spring Cloud Config
 ** to dynamically update configuration properties
 ** without restarting the application.
 *
 * @EventListener
 ** It is used here to listen for ApplicationReadyEvent
 ** and RefreshScopeRefreshedEvent events.
 ** When these events are triggered, the onEvent() method will be called.
 */

@Slf4j
@RefreshScope
@Component
public class ConfigurationsStatusViewer {

    @Autowired
    private Environment environment;

    @Value("${consumer.environment}")
    private String consumerEnvironment;

    @EventListener({ApplicationReadyEvent.class, RefreshScopeRefreshedEvent.class})
    public void onEvent() {
        log.info("Listening to config server: {}", environment.getProperty("spring.cloud.config.uri"));
        log.info("consumer_1 current value: {}", consumerEnvironment);
    }
}
