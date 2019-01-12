package com.tp.algorithms.sort;

import java.security.cert.CollectionCertStoreParameters;

/**
 * 选择排序
 * @author Administrator
 *
 */
public class Selection {
	public static void sort(Comparable[] a) {
		//将a[]按圣墟排列
		int N = a.length;
		for(int i = 0;i<N;i++){
			//将a[i]和a[i+1..N]中最小的元素交换
			int min = i;
			for (int j=i+1;j<N;j++){
				if(less(a[j],a[min])) min = j;
			}
			exch(a,i,min);
		}
	}
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}

}
