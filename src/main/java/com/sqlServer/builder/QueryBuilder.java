package com.sqlServer.builder;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.enums.QueryType;

public interface QueryBuilder {
    QueryBean build(String query);
    static QueryBean buildBean(String query){
        QueryType queryType = QueryType.getQueryType(query);
        return queryType.getBuilder().build(query);
    }
}
