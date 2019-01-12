package com.tp.algorithms.base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 加权union-find算法
 * @author Administrator
 *
 */
public class WeightedQuickUnionUF {
	private int[] id;//父链接数组
	private int[] sz;//各个根节点所对应的分量的大小
	private int count;//分量数量
	
	public WeightedQuickUnionUF(int N) {
		//初始化分量id数组
		count = N;
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
		}
		sz = new int[N];
		for(int i=0;i<N;i++)	sz[i] = 1;
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	
	public int find(int p) {
		//跟随链接找到根节点
		while(p!=id[p]) p = id[p];
		return p;
		
	}
	
	public void union(int p, int q) {
		//将p和q根节点统一
		int i = find(p);
		int j = find(q);
		if(i==j)	return;
		//将小树的根节点连接到大树的根节点
		
		if(sz[i]<sz[j]) {id[i] = j;sz[j] += sz[i];}
		else			{id[j] = i;sz[i] += sz[j];}
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.print(p+" "+q);
		}
		StdOut.println(uf.count+"components");
	}
	
}
