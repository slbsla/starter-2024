package com.slb.dev.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JobStarterService {

    @Value("${file.input}")
    private String input;

    @Value("${file.output}")
    private String output;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("importingPriceJob")
    private Job importingPriceJob;

    public void start() throws Exception {
        JobParametersBuilder paramsBuilder = new JobParametersBuilder();
        paramsBuilder.addDate("date", new Date());
        paramsBuilder.addString("inputFile", input);
        jobLauncher.run(importingPriceJob, paramsBuilder.toJobParameters());
    }
}
