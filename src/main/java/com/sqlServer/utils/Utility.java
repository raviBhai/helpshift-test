package com.sqlServer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static String getStringBetween(String input, String start, String end) {
        Pattern pattern = Pattern.compile(start + "(.*?)" + end);
        Matcher matcher = pattern.matcher(input);
        String result = null;
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public static boolean isOnlyAlpha(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static boolean isOnlyNumber(String input) {
        return input.matches("[0-9]+");
    }
}
