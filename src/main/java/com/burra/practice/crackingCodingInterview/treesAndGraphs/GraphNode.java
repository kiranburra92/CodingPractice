package com.burra.practice.crackingCodingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public int dependencies = 0 ;
    public boolean isVisted;
    public List<GraphNode> adjList = new ArrayList<>();

    public GraphNode(int _val) {
        val = _val;
    }

    public GraphNode() {
        val = 0;
    }
}
