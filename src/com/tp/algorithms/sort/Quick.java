package com.tp.algorithms.sort;

/**
 * 快速排序
 */
public class Quick {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1); //将左半部分排序
        sort(a,j+1,hi); //将右半部分排序
    }

    //切分数组
    private static int partition(Comparable[] a, int lo, int hi){
        //将数组切分为
        int i = lo,j = hi + 1;//左右扫描指针
        Comparable  v = a[lo];//切分元素
        while (true){
            //扫描左右,检查扫描是否结束并交换元素
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v,a[--j]))   if(j == lo) break;
            if(i>=j)    break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
