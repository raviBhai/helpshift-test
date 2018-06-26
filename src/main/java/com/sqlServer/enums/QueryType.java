package com.sqlServer.enums;

import com.sqlServer.builder.InsertQueryBuilder;
import com.sqlServer.builder.QueryBuilder;
import com.sqlServer.builder.SelectQueryBuilder;
import com.sqlServer.executor.InsertQueryExecutor;
import com.sqlServer.executor.QueryExecutor;
import com.sqlServer.executor.SelectQueryExecutor;
import com.sqlServer.validator.InsertQuerySyntaxValidator;
import com.sqlServer.validator.SelectQuerySyntaxValidator;
import com.sqlServer.validator.SyntaxValidator;

public enum QueryType {
    SELECT("select") {
        @Override
        public SyntaxValidator getValidator() {
            return new SelectQuerySyntaxValidator();
        }

        @Override
        public QueryBuilder getBuilder() {
            return new SelectQueryBuilder();
        }

        @Override
        public QueryExecutor getExecutor() {
            return new SelectQueryExecutor();
        }
    },

    INSERT("insert") {
        @Override
        public SyntaxValidator getValidator() {
            return new InsertQuerySyntaxValidator();
        }

        @Override
        public QueryBuilder getBuilder() {
            return new InsertQueryBuilder();
        }

        @Override
        public QueryExecutor getExecutor() {
            return new InsertQueryExecutor();
        }
    };

    QueryType(String type) {
        this.type = type;
    }

    private String type;


    public static QueryType getQueryType(String query) {
        for (QueryType queryType : QueryType.values()) {
            if (query.toLowerCase().startsWith(queryType.type)) {
                return queryType;
            }
        }
        return null;
    }

    public abstract SyntaxValidator getValidator();
    public abstract QueryBuilder getBuilder();
    public abstract QueryExecutor getExecutor();
}
