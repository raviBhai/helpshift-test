package com.sqlServer.filter;

import java.util.List;

public interface Filter<T, E> {
    List<T> filter(List<T> records, E filter);
}
