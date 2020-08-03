package com.nix.module.util;

import java.util.*;

public class StringUtil {
    public static String getFirstUniqueString(List<String> list) {
        Map<String, Integer> uniqueStrings = new HashMap<>();
        int min = Integer.MAX_VALUE;
        String result = "";

        for (int i = list.size() - 1; i >= 0; i--) {
            String currentString = list.get(i);
            if (!uniqueStrings.containsKey(list.get(i))) {
                uniqueStrings.put(currentString, i);
            } else {
                uniqueStrings.remove(list.get(i));
            }
        }


        for (Map.Entry<String, Integer> entry : uniqueStrings.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
