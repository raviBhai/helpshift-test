package com.sqlServer.filter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.sqlServer.bean.QueryBean;
import com.sqlServer.domain.Actor;
import static com.sqlServer.utils.Metadata.getDbTablesMetadata;

public class ActorQueryFilter implements Filter<Actor, QueryBean> {

    @Override
    public List<Actor> filter(List<Actor> actors, QueryBean filter) {
        List<Actor> result = new ArrayList<>();
        String columnName = filter.getColumnNameFromClause();
        String data = filter.getFilterDataFromClause();

        Actor actor = actors.get(0);
        boolean isFieldTypeString = false;
        try {
            Field field = Actor.class.getDeclaredField(columnName);
            Object value = field.get(actor);
            String s = field.getType().toGenericString();

            if (s.contains("String")) {
                isFieldTypeString = true;
            }
        } catch (Exception e) {

        }

        for (Actor a : actors) {
            if (isFieldTypeString) {

            } else {

            }
        }
        return result;
    }
}
