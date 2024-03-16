package com.slb.dev.conf.processor;

import com.slb.dev.model.Prix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyItemProcessor implements ItemProcessor<Prix, Prix> {

    private static final Logger log = LoggerFactory.getLogger(MyItemProcessor.class);


    public Prix process(Prix prix) throws Exception {

        log.info("processing..");

        return Prix.builder()
                .devise(convertDevis(prix.getDevise()))
                .reference(prix.getReference())
                .value(prix.getValue())
                .source(prix.getSource())
                .execution(LocalDateTime.now())
                .build();
    }

    private String convertDevis(String devise)  {
        if (devise == null || devise.isEmpty()) {
            log.info("value could not be null");
            return null ;
        }else {
            return  devise.toUpperCase();
        }
    }
}
