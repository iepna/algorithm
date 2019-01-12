package com.tp.algorithms.base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find:quick-union实现
 * @author Administrator
 *
 */
public class UF {
	private int[] id;//分量id
	private int count;//分量数量
	
	public UF(int N) {
		//初始化分量id数组
		count = N;
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
		}
	}
	
	public int count() {
		return count;
	}
	
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	
	public int find(int p) {
		//找出分量的名称
		while(p!=id[p]) p = id[p];
		return p;
		
	}
	
	public void union(int p, int q) {
		//将p和q根节点统一
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot==qRoot)	return;
		id[pRoot] = qRoot;
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
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
