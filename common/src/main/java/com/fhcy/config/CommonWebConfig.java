package com.fhcy.config;

import com.fhcy.converter.DateFormatter;
import com.fhcy.ctx.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaobzhou
 * date 2019-07-30 21:42
 */
@Configuration
@ConditionalOnClass(WebMvcConfigurer.class)
public class CommonWebConfig {

    @Autowired
    private ApplicationContext ctx;

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder(ctx);
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }
}