package com.sqlServer.columnSelector;

import java.util.List;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.domain.Inventor;

public class InventorColumnSelector implements ColumnSelector<Inventor> {
    @Override
    public String selectColumnData(List<Inventor> records, QueryBean bean) {
        return null;
    }
}
