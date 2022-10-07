package com.kratonsolution.belian.common.util;

import com.google.common.base.Strings;

public class NumberHelper {

    public static int toInt(String numberString) {

        if(!Strings.isNullOrEmpty(numberString))
            return Integer.parseInt(numberString);

        return 0;
    }

    public static int toInt(String numberString, int defaultValue) {

        if(!Strings.isNullOrEmpty(numberString))
            return Integer.parseInt(numberString);

        return defaultValue;
    }
}
