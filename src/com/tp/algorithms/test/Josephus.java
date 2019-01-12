package com.tp.algorithms.test;

import java.util.Scanner;

import com.tp.algorithms.base.RandomQueue;

public class Josephus {
	//1.3.37题目答案
	private int N;
	private int M;
	
	private RandomQueue q;

	public Josephus(int N,int M) {
		super();
		this.N = N;
		this.M = M;
		this.q = new RandomQueue();
		for(int i=0;i<N;i++){
			q.enqueue(i);
		}
	}
	
	private int run(int j, int index){

		for(int i=0;i<M;i++){
			if(index==M-1){
				index = 0;
			}else{
				index++;
			}	
		}
		System.out.print(q.remove(index)+",");
		index --;
		if(j%5==0){
			System.out.println();
		}
		return index;
	}
	public static void main(String[] args) {
		while(true){
			System.out.print("请输入n和m(n,m)：");
			String s = new Scanner(System.in).nextLine();
			if(!s.matches("\\d{1,},\\d{1,}")){
				System.out.println("输入格式不符！！");
				return ;
			}
			String[] ss = s.split(",");
			Josephus jo = new Josephus(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
			int j = 0;
			int index = 0;
			while(!jo.q.isEmpty()){
				index = jo.run(j, index);
				j++;
			}
		}
	}
}
