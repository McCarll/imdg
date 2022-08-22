package com.vrudometkin.imdg.imdgtest;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbStorage {
    @Autowired
    ResourceLoader resourceLoader;
    public List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        try (Reader reader = new InputStreamReader(resourceLoader.getResource("classpath:data.csv").getInputStream())) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    products.add(new Product(line));
                }
            }
        }catch (Exception e){

        }
    }
}
