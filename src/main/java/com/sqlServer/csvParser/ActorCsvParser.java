package com.sqlServer.csvParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.sqlServer.domain.Actor;

public class ActorCsvParser implements CsvParser<Actor, String> {
    @Override
    public List<Actor> read(String fileName) {
        return parseCSVFileAsList();
    }

    @Override
    public boolean write(String fileName, Actor record) {
        return false;
    }

    private List<Actor> parseCSVFileAsList() {
        try {
            //create CSVReader object
            CSVReader reader = new CSVReader(new FileReader("actors.csv"), ',');

            List<Actor> actors = new ArrayList<>();
            //read all lines at once
            List<String[]> records = reader.readAll();

            Iterator<String[]> iterator = records.iterator();
            //skip header row
            iterator.next();
            while (iterator.hasNext()) {
                String[] record = iterator.next();
                Actor actor = new Actor();
                actor.setId(Integer.parseInt(record[0]));
                actor.setName(record[1]);
                actor.setAge(Integer.parseInt(record[2]));
                actors.add(actor);
            }
            reader.close();
            return actors;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
