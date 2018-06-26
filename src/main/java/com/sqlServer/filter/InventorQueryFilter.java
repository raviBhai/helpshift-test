package com.sqlServer.filter;

import java.util.List;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.domain.Inventor;

public class InventorQueryFilter implements Filter<Inventor, QueryBean> {
    @Override
    public List<Inventor> filter(List<Inventor> records, QueryBean filter) {
        return null;
    }
}
