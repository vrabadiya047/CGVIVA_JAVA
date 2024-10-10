package com.cargarantie.leanix.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.leanix.api.common.ApiException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LeanixSchedulerService {

    private final LeanixGraphQlService service;

    @Scheduled(cron = "${cron.job1}")
    public void doScheduledJob() {
        try {
            log.info("Start scheduled job execution...");
            service.searchFactSheets("*");
            log.info("Done");
        } catch (ApiException e) {
            log.error("Scheduler execution failed.", e);
        }
    }
}
