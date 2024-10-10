package com.cargarantie.leanix;

import com.cargarantie.leanix.service.LeanixGraphQlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.leanix.api.common.ApiException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
@ConfigurationPropertiesScan
public class VicaScoreCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VicaScoreCalculatorApplication.class, args);
    }
}
