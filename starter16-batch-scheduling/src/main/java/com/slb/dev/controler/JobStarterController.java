package com.slb.dev.controler;

import com.slb.dev.service.JobStarterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class JobStarterController {

    @Autowired
    private JobStarterService jobStarterService;

    @GetMapping("/run")
    public String run() throws Exception {
        log.info("try to strat");
        jobStarterService.start();
        log.info("started");
        return "Successfully started";
    }
}