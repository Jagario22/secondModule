package com.nix.module.util.DijkstraAlgorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class DijkstraAlgorithm {

    public static int findCheapestWay(int[][] matrix, int first, int last) {
        int[] costs = new int[matrix.length];
        boolean[] x = new boolean[matrix.length];
        int start;
        int min;

        for (int i = 0; i < matrix.length; i++) {
            if (i != first) {
                Arrays.fill(costs, Integer.MAX_VALUE);
                Arrays.fill(x, false);

                costs[first] = 0;
                x[first] = true;
                start = first;

                while (true) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[start][j] == 0)
                            continue;
                        if (!x[j] && costs[j] > costs[start] + matrix[start][j]) {
                            costs[j] = costs[start] + matrix[start][j];
                        }
                    }

                    min = Integer.MAX_VALUE;
                    for (int j = 0; j < matrix.length; j++) {
                        if (!x[j] && costs[j] < min) {
                            start = j;
                            min = costs[j];
                        }
                    }

                    if (start == i)
                        break;
                    x[start] = true;
                }
            }
        }
        log.debug("Costs of shortest way for path " + (first + 1) + "-" + (last + 1) + ": " + costs[last]);
        return costs[last];
    }
}
