package com.nix.module.util.DijkstraAlgorithm;

import java.util.List;

public class WeightedGraph {
    private List<String> nameOfNodes;
    private int[][] matrix;

    public WeightedGraph(List<String> nameOfNodes, int[][] matrix) {
        this.nameOfNodes = nameOfNodes;
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
