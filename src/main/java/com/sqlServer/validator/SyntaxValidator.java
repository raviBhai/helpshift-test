package com.sqlServer.validator;

import com.sqlServer.enums.QueryType;

public interface SyntaxValidator extends Validator<String> {

    static boolean validateSyntax(String query){
        QueryType queryType = QueryType.getQueryType(query);
        return queryType.getValidator().validate(query);
    }
}
