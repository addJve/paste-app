package com.addjve.pasteapp.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myapp")
@Getter @Setter
public class ConfigProperties {
    private String host;
    private int listSizeToShow;
    private long timeInSecondsToShow;
}
