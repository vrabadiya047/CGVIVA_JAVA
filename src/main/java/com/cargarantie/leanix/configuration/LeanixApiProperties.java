package com.cargarantie.leanix.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("leanix")
public class LeanixApiProperties {
    private String token;
    private String authProviderHost;
    private String apiUrl;
}
