package com.tp.algorithms.graph.graph;


import com.tp.algorithms.base.Queue;
import com.tp.algorithms.base.Stack;

/**
 * 广度优先搜索算法
 * 查找最短路径
 */
public class BreadthFirstPaths {
    private boolean[] marked;//到达改订点的最短路径已知吗
    private int[] edgeTo;//到达该顶点的已知路径的最后一个顶点
    private final int s;//起点
    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    private void bfs(Graph G, int s){
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;//标记起点
        queue.enqueue(s);//将它加入队列
        while(!queue.isEmpty()){
            int v = queue.dequeue();//从队列中删去下一个顶点
            for (int w:G.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

}
