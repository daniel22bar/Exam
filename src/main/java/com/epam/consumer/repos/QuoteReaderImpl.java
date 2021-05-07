package com.epam.consumer.repos;

import com.epam.common.model.Quote;
import com.epam.infra.InjectValue;
import lombok.SneakyThrows;

import java.io.*;

public class QuoteReaderImpl implements QuoteReader {

    @InjectValue("producer_output_location")
    private String producerLocationDir;

    @Override
    @SneakyThrows
    public Quote getQuoteFromFile(String fileName) {
        return (Quote) new ObjectInputStream(new FileInputStream(producerLocationDir+fileName)).readObject();
    }
}
