package com.sqlServer.bean;

import lombok.Getter;
import lombok.Setter;

import com.sqlServer.constants.AppConstants;
import com.sqlServer.enums.QueryType;

@Getter @Setter
public class QueryBean implements AppConstants {
    private String queryType;
    private String columns;
    private String table;
    private String clause;

    public String getColumnNameFromClause() {
        String columnName = "";
        if (clause.contains(GT_EQ)) {
            columnName = clause.split(GT_EQ)[0];
        }
        if (clause.contains(LT_EQ)) {
            columnName = clause.split(LT_EQ)[0];
        }
        if (clause.contains(EQ)) {
            columnName = clause.split(EQ)[0];
        }
        if (clause.contains(GT)) {
            columnName = clause.split(GT)[0];
        }
        if (clause.contains(LT)) {
            columnName = clause.split(LT)[0];
        }
        return columnName;
    }

    public String getFilterDataFromClause() {
        String data = "";
        if (clause.contains(GT_EQ)) {
            data = clause.split(GT_EQ)[1];
        }
        if (clause.contains(LT_EQ)) {
            data = clause.split(LT_EQ)[1];
        }
        if (clause.contains(EQ)) {
            data = clause.split(EQ)[1];
        }
        if (clause.contains(GT)) {
            data = clause.split(GT)[1];
        }
        if (clause.contains(LT)) {
            data = clause.split(LT)[1];
        }
        return data;
    }
}
