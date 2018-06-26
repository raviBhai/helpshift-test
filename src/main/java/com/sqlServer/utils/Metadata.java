package com.sqlServer.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Metadata {
    private static Map<String, Set<String>> dbTablesMetadata = new HashMap() {
        {
            put("actors", new HashSet() {
                {
                    add("id");
                    add("name");
                    add("age");
                }
            });
            put("inventors", new HashSet() {
                {
                    add("id");
                    add("name");
                    add("age");
                    add("salary");
                    add("country");
                }
            });
        }
    };

    public static Map<String, Set<String>> getDbTablesMetadata() {
        return dbTablesMetadata;
    }
}
