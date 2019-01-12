package com.tp.algorithms.graph.digraph;

/**
 * 拓扑排序
 */
public class Topological {
    private Iterable<Integer> order;//顶点拓扑的顺序

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }
    public Iterable<Integer> order(){
        return order;
    }
    public boolean isDAG() {
        return order != null;
    }
}
