package com.sqlServer.executor;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.enums.QueryType;

public interface QueryExecutor extends Executor<String, QueryBean> {
    static String executeQuery(QueryBean bean) {
        QueryType queryType = QueryType.getQueryType(bean.getQueryType());
        return queryType.getExecutor().execute(bean);
    }
}
