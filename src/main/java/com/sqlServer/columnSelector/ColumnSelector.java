package com.sqlServer.columnSelector;

import java.util.List;

import com.sqlServer.bean.QueryBean;

public interface ColumnSelector<E> {
    /**
     * Selects specific columns as per the query
     * @param records
     * @return
     */
    String selectColumnData(List<E> records, QueryBean bean);
}
