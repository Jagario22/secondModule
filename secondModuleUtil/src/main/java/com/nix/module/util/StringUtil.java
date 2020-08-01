package com.nix.module.util;

import java.util.*;

public class StringUtil {
    public static String getFirstUniqueString(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String val : names) {
            if (uniqueNames.add(val)) {
                result.add(val);
            } else {
                result.remove(val);
            }
        }

        return result.get(0);
    }
}
