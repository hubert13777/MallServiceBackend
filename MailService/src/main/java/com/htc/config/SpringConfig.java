package com.htc.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = "com.htc", excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Controller.class
))
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}