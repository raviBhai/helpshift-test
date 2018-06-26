package com.sqlServer.validator;

import com.sqlServer.constants.AppConstants;
import com.sqlServer.utils.Utility;

public class SelectQuerySyntaxValidator implements SyntaxValidator, AppConstants {

    @Override
    public boolean validate(String query) {
        int selectIndex = query.indexOf(SELECT);
        int fromIndex = query.indexOf(FROM);
        int whereIndex = query.indexOf(WHERE);
        int semicolonIndex = query.indexOf(SEMICOLON);

        if (!isSemicolonPresent(semicolonIndex)) {
            return false;
        } else {
            if (whereClausePresent(whereIndex)) {
                if (isValidSequenceOfSelectFromWhere(selectIndex, fromIndex, whereIndex, semicolonIndex)) {
                    if(!invalidColumnNames(query) && !invalidTableName(query) && !invalidClause(query)) {
                        return true;
                    }
                }
            } else {
                if (isValidSequenceOfSelectFrom(selectIndex, fromIndex)) {
                    if(!invalidColumnNames(query) && !invalidTableName(query)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isSemicolonPresent(int semicolonIndex) {
        return semicolonIndex != -1;
    }

    private boolean isValidSequenceOfSelectFrom(int selectIndex, int fromIndex) {
        return selectIndex < fromIndex;
    }

    private boolean isValidSequenceOfSelectFromWhere(int selectIndex, int fromIndex, int whereIndex, int semicolonIndex) {
        return isValidSequenceOfSelectFrom(selectIndex, fromIndex) && fromIndex < whereIndex && whereIndex < semicolonIndex;
    }

    private boolean whereClausePresent(int whereIndex) {
        return whereIndex != -1;
    }

    private boolean invalidColumnNames(String query) {
        String columns = Utility.getStringBetween(query, SELECT, FROM);
        if (columns.startsWith(COMMA) || columns.endsWith(COMMA)) {
            return true;
        }
        return false;
    }

    private boolean invalidTableName(String query) {
        String table = Utility.getStringBetween(query, FROM, WHERE);
        if (table.contains(COMMA)) {
            return true;
        }
        return false;
    }

    private boolean invalidClause(String query) {
        String clause = Utility.getStringBetween(query, WHERE, SEMICOLON);
        if (clause.contains(COMMA)) {
            return true;
        }
        if (checkInvalidExpressionInClause(clause, GT_EQ)) {
            return true;
        }
        if (checkInvalidExpressionInClause(clause, LT_EQ)) {
            return true;
        }
        if (checkInvalidExpressionInClause(clause, EQ)) {
            return true;
        }
        if (checkInvalidExpressionInClause(clause, GT)) {
            return true;
        }
        if (checkInvalidExpressionInClause(clause, LT)) {
            return true;
        }
        return false;
    }

    private boolean checkInvalidExpressionInClause(String clause, String exp) {
        String[] split = null;
        if (clause.contains(exp)) {
            split = clause.split(exp);
            if (!Utility.isOnlyAlpha(split[0].trim())) {
                return true;
            }
            String data = split[1].trim();
            if (data.startsWith(DOUBLE_QUOTES) && data.endsWith(DOUBLE_QUOTES)) {
                //do nothing as it is valid data
            } else {
                if (!Utility.isOnlyNumber(data)) {
                    return true;
                }
            }
        }
        return false;
    }
}
