package com.dmtaiwan.alexander.myapplication;

import java.util.ArrayList;

/**
 * Created by Alexander on 3/13/2017.
 */

public class StringGenerator {
    private static StringGenerator stringGenerator;
    private ArrayList<String> strings;

    private StringGenerator() {
        strings = new ArrayList<>();
        strings.add("FIRST");
        strings.add("SECOND");
        strings.add("THIRD");
        strings.add("FOURTH");
        strings.add("FIFTH");
        strings.add("SIXTH");
        strings.add("SEVENTH");
    }

    public static StringGenerator get() {
        if (stringGenerator == null) {
            stringGenerator = new StringGenerator();
        }
        return stringGenerator;
    }

    public ArrayList<String> getStrings() {
        return strings;
    }
}
