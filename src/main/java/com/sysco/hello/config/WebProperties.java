package com.sysco.hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web")
public class WebProperties {

    private String _color;

    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        _color = color;
    }
}
