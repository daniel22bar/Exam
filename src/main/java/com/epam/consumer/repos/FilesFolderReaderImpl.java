package com.epam.consumer.repos;

import com.epam.infra.InjectValue;

import java.io.File;

public class FilesFolderReaderImpl implements FilesFolderReader {
    @InjectValue("producer_output_location")
    private String producerLocationDir;

    @Override
    public String[] getAllFilesInFolder() {
        return new File(producerLocationDir).list();
    }
}
