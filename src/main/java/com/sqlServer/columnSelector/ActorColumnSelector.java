package com.sqlServer.columnSelector;

import java.util.List;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.domain.Actor;

public class ActorColumnSelector implements ColumnSelector<Actor> {
    @Override
    public String selectColumnData(List<Actor> records, QueryBean bean) {

        return "Empty String";
    }
}
