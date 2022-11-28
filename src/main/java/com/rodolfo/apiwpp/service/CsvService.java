package com.rodolfo.apiwpp.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.rodolfo.apiwpp.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CsvService {

     final Logger logger = LoggerFactory.getLogger(CsvService.class);

    private final String FILE_NAME = "uTalkLote.csv";
    public CsvService() {
    }

    public List<Contact> readCsv(File csvContacts) {
        try {
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            List<Contact> contacts = new ArrayList<>();
            CSVReader reader = new CSVReaderBuilder(new FileReader(csvContacts)).withCSVParser(parser).build();
            int cont = 0;
            for (Iterator<String[]> it = reader.iterator(); it.hasNext(); ) {
                String[] nextLine = it.next();
                if (cont != 0) {
                    contacts.add(new Contact(nextLine[0], nextLine[1]));
                }
                cont++;
            }
            return contacts;

        } catch (FileNotFoundException e) {
            logger.info("Não foi possível localizar o CSV no diretório " + FILE_NAME);
        }
        return Collections.EMPTY_LIST;
    }

}
