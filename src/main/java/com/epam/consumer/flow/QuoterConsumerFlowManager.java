package com.epam.consumer.flow;

import com.epam.common.model.Quote;
import com.epam.consumer.services.ConvertObjectToJson;
import com.epam.consumer.repos.FilesFolderReader;
import com.epam.consumer.repos.QuoteAsJsonSaver;
import com.epam.consumer.repos.QuoteReader;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuoterConsumerFlowManager {

    private QuoteReader quoteReader;
    private FilesFolderReader filesFolderReader;
    private ConvertObjectToJson objectToJson ;
    private QuoteAsJsonSaver quoteAsJsonSaver ;

    void consumeQuotes(){
        for (String fileName : filesFolderReader.getAllFilesInFolder()) {
            Quote quote = quoteReader.getQuoteFromFile(fileName);
            String json = objectToJson.convertObjectToJson(quote);
            Thread t1 = new Thread(()-> quoteAsJsonSaver.saveJsonQuote(json));
            t1.start();
            System.out.println(t1.toString());
        }
    }

}
