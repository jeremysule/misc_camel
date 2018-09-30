package com.jsule.demo_xa_db.delivery;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.data.relational.core.mapping.event.RelationalEvent;

@Configuration
@EnableJdbcRepositories
@Import(JdbcConfiguration.class)
public class DeliveryConfiguration {

    @Bean
    public ApplicationListener<?> loggingListener() {

        return (ApplicationListener<ApplicationEvent>) event -> {
            if (event instanceof RelationalEvent) {
                System.out.println("Received an event: " + event);
            }
        };
    }

}
