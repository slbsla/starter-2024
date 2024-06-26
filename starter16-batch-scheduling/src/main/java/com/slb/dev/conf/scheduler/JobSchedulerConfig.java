package com.slb.dev.conf.scheduler;

import com.slb.dev.service.JobStarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JobSchedulerConfig {

    @Autowired
    private JobStarterService service;

    @Scheduled(fixedDelay = 30000)
    public void scheduleFixedDelayTask() throws Exception {
        service.start();
    }
}
