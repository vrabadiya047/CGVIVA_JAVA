package com.cargarantie.leanix.configuration;

import lombok.RequiredArgsConstructor;
import net.leanix.api.common.ApiClient;
import net.leanix.api.common.ApiClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApiClientConfiguration {

    private final LeanixApiProperties properties;

    @Bean
    public ApiClient apiClient() {
        return new ApiClientBuilder()
                .withBasePath(properties.getApiUrl())
                .withApiToken(properties.getToken())
                .withTokenProviderHost(properties.getAuthProviderHost())
                .build();
    }
}
