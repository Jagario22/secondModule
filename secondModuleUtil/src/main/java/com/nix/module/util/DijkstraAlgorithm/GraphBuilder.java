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
    private static int[][] pathsToFind;

    public static WeightedGraph build(String inputFile) throws Exception {
        int n, p, numOfPathsToFind;
        String line;
        String[] paths;
        File file = new File(inputFile);
        Map<String, Integer> nameOfCities = new HashMap<>();

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
                nameOfCities.put(line, i);

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
                    log.debug("paths: " + line);
                    paths = line.split(" ");
                    matrix[i][Integer.parseInt(paths[0]) - 1] = Integer.parseInt(paths[1]);
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

                log.debug("paths to find: " + line);
                paths = line.replace("-", " ").split(" ");
                pathsToFind[i][0] = nameOfCities.get(paths[0]);
                pathsToFind[i][1] = nameOfCities.get(paths[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.debug("matrix: " + Arrays.deepToString(matrix));
        return new WeightedGraph(new ArrayList<>(nameOfCities.keySet()), matrix);
    }

    //getters
    public static int[][] getPathsToFind() {
        return pathsToFind;
    }
}
