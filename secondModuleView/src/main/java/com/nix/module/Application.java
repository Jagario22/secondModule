package com.nix.module;


import com.nix.module.util.DatesUtil;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<String> dates = Arrays.asList("2021-04-05", "05/04/2022", "04-05-2023", "05.04.2024");
        List<String> datesInCorrectFormat = DatesUtil.getYearsInCorrectFormat(dates);
        datesInCorrectFormat.forEach(System.out::println);
        System.out.println();

    }
}