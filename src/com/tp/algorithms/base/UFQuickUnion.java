package com.tp.algorithms.base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * union-find:quick-findʵ��
 * @author Administrator
 *
 */
public class UFQuickUnion {
	private int[] id;//����id
	private int count;//��������
	
	public UFQuickUnion(int N) {
		//��ʼ������id����
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
		//��p��q�鲢����ͬ����֮��
		int pID = find(p);
		int qID = find(q);
		//���p��q�Ѿ�����ͬ�ķ���֮������Ҫ��ȡ�κ��ж�
		if(pID==qID)	return;
		//��p�ķ���������Ϊq������
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
