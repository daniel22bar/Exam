package com.epam.consumer.repos;

import com.epam.common.model.Quote;

public interface QuoteReader {
    Quote getQuoteFromFile(String fileLocation);
}
