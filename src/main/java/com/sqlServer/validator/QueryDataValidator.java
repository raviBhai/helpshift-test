package com.sqlServer.validator;

import static com.sqlServer.utils.Metadata.getDbTablesMetadata;

import java.util.Set;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.constants.AppConstants;

public class QueryDataValidator implements Validator<QueryBean>, AppConstants {

    @Override
    public boolean validate(QueryBean bean) {
        TableNameValidator tableNameValidator = new TableNameValidator();
        ColumnNameValidator columnNameValidator = new ColumnNameValidator();
        ClauseDataValidator clauseDataValidator = new ClauseDataValidator();

        return tableNameValidator.validate(bean)
                && columnNameValidator.validate(bean)
                && clauseDataValidator.validate(bean);
    }

    class TableNameValidator implements Validator<QueryBean> {
        @Override
        public boolean validate(QueryBean bean) {
            return getDbTablesMetadata().get(bean.getTable()) != null;
        }
    }

    class ColumnNameValidator implements Validator<QueryBean> {
        @Override
        public boolean validate(QueryBean bean) {
            String requestColumns = bean.getColumns();
            if (requestColumns.equals(ASTERIX)) {
                return true;
            } else {
                String[] allColumns = bean.getColumns().split(COMMA);
                Set<String> dbColumns = getDbTablesMetadata().get(bean.getTable());

                for (String column : allColumns) {
                    if (!dbColumns.contains(column.trim())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class ClauseDataValidator implements Validator<QueryBean> {
        @Override
        public boolean validate(QueryBean bean) {
            String columnName = bean.getColumnNameFromClause();
            Set<String> dbColumns = getDbTablesMetadata().get(bean.getTable());
            if (!dbColumns.contains(columnName.trim())) {
                return false;
            }
            return true;
        }
    }
}
