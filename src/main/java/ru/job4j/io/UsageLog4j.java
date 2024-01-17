package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        char c = '3';
        int i = 4;
        long l = 5L;
        float f = 5.5f;
        double d = 5.6;
        boolean e = true;
        LOG.debug("Variables byte: {}, short: {}, char: {}, int: {}, long: {}, float: {}, double: {}, "
                + "boolean: {}", b, s, c, i, l, f, d, e);
    }
}
