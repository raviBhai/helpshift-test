package com.sqlServer.executor;

import java.util.List;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.columnSelector.ColumnSelector;
import com.sqlServer.csvParser.CsvParser;
import com.sqlServer.domain.Actor;
import com.sqlServer.enums.Tables;
import com.sqlServer.filter.Filter;

public class SelectQueryExecutor implements QueryExecutor {
    @Override
    public String execute(QueryBean bean) {
        Tables table = Tables.getTable(bean.getTable());
        CsvParser csvParser = table.getCsvParser();
        List<Actor> actors = csvParser.read(bean.getTable());
        Filter filter = table.getFilter();
        actors = filter.filter(actors, bean.getTable());
        ColumnSelector columnSelector = table.getColumnSelector();
        String result = columnSelector.selectColumnData(actors, bean);
        return result;
    }
}
