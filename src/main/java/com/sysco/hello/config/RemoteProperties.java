package com.sysco.hello.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "remote")
public class RemoteProperties {
    private String _worldServiceName;

    public RemoteProperties() {
    }

    public String getWorldServiceName() {
        return _worldServiceName;
    }

    public void setWorldServiceName(String worldServiceName) {
        _worldServiceName = worldServiceName;
    }
}
