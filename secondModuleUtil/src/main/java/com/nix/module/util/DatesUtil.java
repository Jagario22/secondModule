package com.nix.module.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DatesUtil {

    public static List<String> getYearsInCorrectFormat(List<String> dates) {
        SimpleDateFormat resultFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        String[] regex = {"\\d{4}-\\d{2}-\\d{2}$", "\\d{2}/\\d{2}/\\d{4}", "\\d{2}-\\d{2}-\\d{4}", "\\d{2}.\\d{2}.\\d{4}"};
        String date;
        List<String> result = new ArrayList<>();

        Map<String, String> formats = new HashMap<>() {{
            put(regex[0], "yyyy-MM-dd");
            put(regex[1], "dd/MM/yyyy");
            put(regex[2], "MM-dd-yyyy");
            put(regex[3], "dd.MM.yyyy");
        }};

        for (String val : dates) {
            for (int i = 0; i < formats.size(); i++) {
                if (val.matches(regex[i])) {
                    try {
                        dateFormat.applyPattern(formats.get(regex[i]));
                        date = resultFormat.format(dateFormat.parse(val));
                    } catch (ParseException e) {
                        continue;
                    }
                    result.add(date);
                }
            }
        }
        return result;
    }



}
