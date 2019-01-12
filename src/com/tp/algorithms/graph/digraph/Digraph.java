package com.tp.algorithms.graph.digraph;

import com.tp.algorithms.base.Bag;

/**
 * 有向图
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v=0;v<v;v++){
            adj[v] = new Bag<>();
        }
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for (int v=0;v<V;v++){
            for (int w:adj(v))
                R.addEdge(w,v);
        }
        return R;
    }
}
