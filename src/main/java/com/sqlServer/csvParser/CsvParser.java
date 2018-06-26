package com.sqlServer.csvParser;

import java.util.List;

public interface CsvParser<T, E> {
    List<T> read(E fileName);

    boolean write(E fileName, T record);
}
