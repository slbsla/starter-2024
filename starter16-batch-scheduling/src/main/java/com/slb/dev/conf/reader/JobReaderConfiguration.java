package com.slb.dev.conf.reader;

import com.slb.dev.model.Prix;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class JobReaderConfiguration {

    @Value("${file.input}")
    private String input;

    @Bean
    @Qualifier("myItemReader")
    public FlatFileItemReader<Prix> myItemReader() {
        return new FlatFileItemReaderBuilder()
                .name("myItemReader")
                .resource(new FileSystemResource(input))
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"id", "source", "value", "devise", "reference"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Prix>() {{
                    setTargetType(Prix.class);
                }})
                .build();
    }
}
