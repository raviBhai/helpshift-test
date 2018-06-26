package com.sqlServer.csvParser;

import java.util.List;

import com.sqlServer.domain.Inventor;

public class InventorCsvParser implements CsvParser<Inventor, String> {
    @Override
    public List<Inventor> read(String fileName) {
        return null;
    }

    @Override
    public boolean write(String fileName, Inventor record) {
        return false;
    }
}
