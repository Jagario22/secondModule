package com.nix.module;


import com.nix.module.fileWriter.CustomFileWriter;
import com.nix.module.fileWriter.FileWriter;
import com.nix.module.util.DatesUtil;
import com.nix.module.util.DijkstraAlgorithm.DijkstraAlgorithm;
import com.nix.module.util.DijkstraAlgorithm.GraphBuilder;
import com.nix.module.util.DijkstraAlgorithm.WeightedGraph;
import com.nix.module.util.StringUtil;

import java.util.*;

public class Application {
    private static final String INPUT_TXT = "input.txt";
    private static final String OUTPUT_TXT = "output.txt";

    public static void main(String[] args) {
        List<String> dates = Arrays.asList("2021-04-05", "05/04/2022", "04-05-2023", "05.04.2024", "5!04!2025");
        List<String> datesInCorrectFormat = DatesUtil.getYearsInCorrectFormat(dates);
        System.out.println("Dates: " + dates.toString());
        System.out.println("Dates after formatting: ");
        datesInCorrectFormat.forEach(System.out::println);
        System.out.println();

        List<String> names = Arrays.asList("Anna", "Sonya", "Erica", "Anna", "Adam", "Adam", "Sonya", "Clara");
        String uniqueName = StringUtil.getFirstUniqueString(names);
        System.out.println("Names: " + names.toString());
        System.out.println("Unique name: " + uniqueName + "\n");

        WeightedGraph graph;

        try {
            graph = GraphBuilder.build(INPUT_TXT);
            int[][] pathsToFind = GraphBuilder.getPathsToFind();

            StringBuilder costOfEveryPath;
            costOfEveryPath = new StringBuilder(String.valueOf(DijkstraAlgorithm.findCheapestWay(graph.getMatrix(), pathsToFind[0][0], pathsToFind[0][1])));
            for (int i = 1; i < pathsToFind.length; i++) {
                costOfEveryPath.append(" ").append(DijkstraAlgorithm.findCheapestWay(graph.getMatrix(), pathsToFind[i][0], pathsToFind[i][1]));

            }

            FileWriter fileWriter = new CustomFileWriter(costOfEveryPath.toString(), OUTPUT_TXT);
            fileWriter.writeIntoFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}