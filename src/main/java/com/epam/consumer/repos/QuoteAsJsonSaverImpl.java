package com.epam.consumer.repos;

import com.epam.infra.InjectValue;
import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuoteAsJsonSaverImpl implements QuoteAsJsonSaver {
    @InjectValue("consumer_output_location")
    private String consumerLocationDir;

    @SneakyThrows
    @Override
    public void saveJsonQuote(String jsonQuote) {
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        FileWriter fw = new FileWriter(consumerLocationDir + fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(jsonQuote);
        bw.close();
    }
}
