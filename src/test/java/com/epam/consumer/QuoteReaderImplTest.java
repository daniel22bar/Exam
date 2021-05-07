package com.epam.consumer;

import com.epam.consumer.repos.QuoteReader;
import com.epam.consumer.repos.QuoteReaderImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class QuoteReaderImplTest extends TestCase {


    @Test
    public void testThatWeCanReadQuote() {

        QuoteReader quoteReader = new QuoteReaderImpl();
        quoteReader.getQuoteFromFile("");
    }
}