package com.nix.module.util.DijkstraAlgorithm;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Slf4j
public class GraphBuilder {
    private static int[][] matrix;
    private static int numOfPathsToFind;
    private static int[][] pathsToFind;

    public static WeightedGraph build(String inputFile) throws Exception {
        int n, p;
        String line;
        String[] path;
        File file = new File(inputFile);
        Map<String, Integer> namesOfCities = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            if (file.length() == 0)
                throw new IOException("This file is empty");

            line = reader.readLine();
            log.debug("num of cities: " + line);
            n = Integer.parseInt(line);
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                log.debug("index: " + i);
                line = reader.readLine();
                if (line == null)
                    throw new Exception("Uncorrected data");
                log.debug("name of city: " + line);
                namesOfCities.put(line, i);

                line = reader.readLine();
                if (line == null) {
                    throw new Exception("Uncorrected data");
                }
                log.debug("countOfNeighbours: " + line);
                p = Integer.parseInt(line);

                for (int j = 0; j < p; j++) {
                    line = reader.readLine();
                    if (line == null) {
                        throw new Exception("Uncorrected data");
                    }
                    log.debug("path: " + line);
                    path = line.split(" ");
                    matrix[i][Integer.parseInt(path[0]) - 1] = Integer.parseInt(path[1]);
                }
            }

            line = reader.readLine();
            if (line == null)
                throw new Exception("Uncorrected data");
            log.debug("num of paths to find: " + line);
            numOfPathsToFind = Integer.parseInt(line);
            pathsToFind = new int[numOfPathsToFind][2];

            for (int i = 0; i < numOfPathsToFind; i++) {
                line = reader.readLine();
                if (line == null)
                    throw new Exception("Uncorrected data");

                log.debug("path to find: " + line);
                path = line.replace("-", " ").split(" ");
                pathsToFind[i][0] = namesOfCities.get(path[0]);
                pathsToFind[i][1] = namesOfCities.get(path[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.debug("matrix: " + Arrays.deepToString(matrix));
        return new WeightedGraph(new ArrayList<>(namesOfCities.keySet()), matrix);
    }

    //getters
    public static int[][] getPathsToFind() {
        return pathsToFind;
    }
}
