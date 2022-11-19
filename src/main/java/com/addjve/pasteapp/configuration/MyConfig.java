package com.addjve.pasteapp.configuration;

import com.addjve.pasteapp.aspects.LoggingAspect;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myapp")
@Getter @Setter
public class MyConfig {
    private String host;
    private int listSizeToShow;
    private long timeInSecondsToShow;
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
