package com.slb.dev.conf;



import com.slb.dev.conf.listener.MyItemListner;
import com.slb.dev.model.Prix;
import com.slb.dev.conf.processor.MyItemProcessor;
import com.slb.dev.conf.writer.MyItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class MainJobConfiguration {

    public static final String STEP_NAME = "step1";
    public static final String JOB_NAME = "myJobName";

    @Autowired
    private JobRepository jobRepository;


    /**
     *
     *         // OLD VERSION
     *         // return jobBuilder.get("importingPriceJob")
     *         //       incrementer(new RunIdIncrementer())
     *         //       .listener(myItemListner)
     *         //       .flow(step1)
     *         //       .end()
     *         //       .build();
     *
     *
     * @param myItemListner
     * @param step1
     * @return
     */
    @Bean
    public Job importingPriceJob(MyItemListner myItemListner, Step step1) {
        var builder = new JobBuilder(JOB_NAME, jobRepository);
        return builder.start(step1).listener(myItemListner).build();
    }

    /**
     *
     *  // OLD VERSION
     *  //        return stepBuilder.get("step1")
     *  //                .<Prix, Prix> chunk(10)
     *  //                .reader(myItemReader())
     *  //                .processor(myItemProcessor)
     *  //                .writer(myItemWriter)
     *  //                .build();
     *
     * @param myItemProcessor
     * @param myItemWriter
     * @param myItemReader
     * @param transactionManager
     * @return
     */


    @Bean
    public Step step1(MyItemProcessor myItemProcessor,
                      MyItemWriter myItemWriter,
                      FlatFileItemReader<Prix> myItemReader,
                      PlatformTransactionManager transactionManager) {

        var builder = new StepBuilder(STEP_NAME, jobRepository);
        return builder.<Prix, Prix>chunk(5, transactionManager)
                .reader(myItemReader)
                .processor(myItemProcessor)
                .writer(myItemWriter)
                .build();


    }
}
