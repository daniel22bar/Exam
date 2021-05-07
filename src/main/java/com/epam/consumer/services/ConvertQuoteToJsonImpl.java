package com.epam.consumer.services;

import com.epam.common.model.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class ConvertQuoteToJsonImpl implements ConvertObjectToJson {
    @Override
    @SneakyThrows
    public String convertObjectToJson(Quote quote) {
       return new ObjectMapper().writeValueAsString(quote);
    }
}
