package com.lcmuniz.rest_with_spring_boot.utils;

public class NumberUtils {

    public static boolean isNegative(Double number) {
        return number < 0;
    }


    public static Double convertToDouble(String string) {
        return Double.parseDouble(string);
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.isEmpty()) return false;
        return string.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

    public static boolean isNotNumeric(String string) {
        return !isNumeric(string);
    }

}
