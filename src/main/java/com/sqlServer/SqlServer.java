package com.sqlServer;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.builder.QueryBuilder;
import com.sqlServer.executor.QueryExecutor;
import com.sqlServer.validator.QueryDataValidator;
import com.sqlServer.validator.SyntaxValidator;

public class SqlServer {

    public String getResultSetFromQuery(String query) {
        boolean isValiQuery = SyntaxValidator.validateSyntax(query);
        String result = "";
        if (isValiQuery) {
            QueryBean queryBean = QueryBuilder.buildBean(query);
            QueryDataValidator queryDataValidator = new QueryDataValidator();
            boolean isValidData = queryDataValidator.validate(queryBean);
            if (isValidData) {
                result = QueryExecutor.executeQuery(queryBean);
            }
        }
        return result;
    }
}
