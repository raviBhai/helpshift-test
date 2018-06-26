package com.sqlServer.builder;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.constants.AppConstants;
import com.sqlServer.enums.QueryType;
import com.sqlServer.utils.Utility;

public class SelectQueryBuilder implements QueryBuilder, AppConstants {
    public QueryBean build(String query) {
        QueryBean queryBean = new QueryBean();
        queryBean.setQueryType(QueryType.getQueryType(query).name());
        queryBean.setColumns(Utility.getStringBetween(query, SELECT, FROM));
        queryBean.setTable(Utility.getStringBetween(query, FROM, WHERE));
        queryBean.setClause(Utility.getStringBetween(query, WHERE, SEMICOLON));
        return queryBean;
    }
}
