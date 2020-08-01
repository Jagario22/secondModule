package com.nix.module.util.DijkstraAlgorithm;

import java.util.List;

public class WeightedGraph {
    private List<String> namesOfNodes;
    private int[][] matrixOfCosts;

    public WeightedGraph(List<String> namesOfNodes, int[][] matrixOfCosts) {
        this.namesOfNodes = namesOfNodes;
        this.matrixOfCosts = matrixOfCosts;
    }

    public int[][] getMatrixOfCosts() {
        return matrixOfCosts;
    }
}
