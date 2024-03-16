package com.slb.dev.conf.writer;

import com.slb.dev.repository.PrixRepository;
import com.slb.dev.model.Prix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyItemWriter implements ItemWriter<Prix> {

    private static final Logger log = LoggerFactory.getLogger(MyItemWriter.class);

    @Autowired
    private PrixRepository prixRepository;

    /**
     *     //  OLD VERSION
     *     public void write(List<? extends Prix> list) throws Exception
     *
     * @param chunk
     * @throws Exception
     */
    @Override
    public void write(Chunk<? extends Prix> chunk) throws Exception {
        try {
            List<? extends Prix> items = chunk.getItems();
            items.forEach(e -> prixRepository.save(e));
            log.info("all items are saved");
        } catch (Exception e) {
            log.error("errors occurs when saving in db");
        }
    }
}
