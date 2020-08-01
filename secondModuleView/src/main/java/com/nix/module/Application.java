package com.nix.module;


import com.nix.module.util.DatesUtil;
import com.nix.module.util.DijkstraAlgorithm.DijkstraAlgorithm;
import com.nix.module.util.DijkstraAlgorithm.GraphBuilder;
import com.nix.module.util.DijkstraAlgorithm.WeightedGraph;
import com.nix.module.util.StringUtil;

import java.util.*;

public class Application {
    private static final String INPUT_TXT = "input.txt";

    public static void main(String[] args) {
        List<String> dates = Arrays.asList("2021-04-05", "05/04/2022", "04-05-2023", "05.04.2024");
        List<String> datesInCorrectFormat = DatesUtil.getYearsInCorrectFormat(dates);
        datesInCorrectFormat.forEach(System.out::println);
        System.out.println();

        List<String> names = Arrays.asList("Anna", "Sonya", "Erica", "Anna", "Adam", "Adam", "Sonya");
        String uniqueName = StringUtil.getFirstUniqueString(names);
        System.out.println(uniqueName + "\n");

        WeightedGraph graph;

        try {
            graph = GraphBuilder.build(INPUT_TXT);
            int[][] path = GraphBuilder.getPathsToFind();

            StringBuilder costs;
            costs = new StringBuilder(String.valueOf(DijkstraAlgorithm.findCheapestWay(graph.getMatrixOfCosts(), path[0][0], path[0][1])));
            for (int i = 1; i < path.length; i++) {
                costs.append(" ").append(DijkstraAlgorithm.findCheapestWay(graph.getMatrixOfCosts(), path[i][0], path[i][1]));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}