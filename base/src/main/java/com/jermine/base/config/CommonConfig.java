package com.jermine.base.config;

import com.jermine.common.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
