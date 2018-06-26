package com.sqlServer.enums;

import com.sqlServer.columnSelector.ActorColumnSelector;
import com.sqlServer.columnSelector.ColumnSelector;
import com.sqlServer.columnSelector.InventorColumnSelector;
import com.sqlServer.csvParser.ActorCsvParser;
import com.sqlServer.csvParser.CsvParser;
import com.sqlServer.csvParser.InventorCsvParser;
import com.sqlServer.filter.ActorQueryFilter;
import com.sqlServer.filter.Filter;
import com.sqlServer.filter.InventorQueryFilter;
import com.sqlServer.validator.SyntaxValidator;

public enum Tables {
    ACTOR("actors"){
        @Override
        public CsvParser getCsvParser() {
            return new ActorCsvParser();
        }

        @Override
        public Filter getFilter() {
            return new ActorQueryFilter();
        }

        @Override
        public ColumnSelector getColumnSelector() {
            return new ActorColumnSelector();
        }
    },

    INVENTOR("inventors"){
        @Override
        public CsvParser getCsvParser() {
            return new InventorCsvParser();
        }

        @Override
        public Filter getFilter() {
            return new InventorQueryFilter();
        }

        @Override
        public ColumnSelector getColumnSelector() {
            return new InventorColumnSelector();
        }
    };

    Tables(String table) {
        this.table = table;
    }

    private String table;

    public static Tables getTable(String tableName) {
        for (Tables table : Tables.values()) {
            if (tableName.startsWith(table.table)) {
                return table;
            }
        }
        return null;
    }

    public abstract CsvParser getCsvParser();
    public abstract Filter getFilter();
    public abstract ColumnSelector getColumnSelector();
}
