package com.tp.algorithms.base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find:quick-find实现
 * @author Administrator
 *
 */
public class UFQuickUnion {
	private int[] id;//分量id
	private int count;//分量数量
	
	public UFQuickUnion(int N) {
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
	
		return id[p];
		
	}
	
	public void union(int p, int q) {
		//将p和q归并到相同分量之中
		int pID = find(p);
		int qID = find(q);
		//如果p和q已经在相同的分量之中则不需要采取任何行动
		if(pID==qID)	return;
		//将p的分量重命名为q的名称
		for(int i=0;i<id.length;i++) {
			if(id[i]==id[pID]) id[i] = qID;
			
		}
		count--;
	}
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UFQuickUnion uf = new UFQuickUnion(N);
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
