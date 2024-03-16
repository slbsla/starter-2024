package com.slb.dev.conf.listener;

import com.slb.dev.model.Prix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Qualifier("myItemListner")
public class  MyItemListner extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(MyItemListner.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
            log.info("====================[FINISHED SUCCESS] ====================");

            jdbcTemplate.query("SELECT source, devise FROM prix",
                    (rs, row) -> new Prix(
                            rs.getString(1),
                            rs.getString(2))
             ).forEach(person -> log.info("Found <" + person + "> in the database."));
         }
        if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
            log.info("====================[FAILY FINISHED] ====================");
        }
    }
}
