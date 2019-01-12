package com.tp.algorithms.base;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[10];
	private int N;
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public void enqueue(Item item){
		if(N==a.length)	resize();
		a[N] = item;
		N++;
	}

	private void resize() {
		Item[] b = (Item[]) new Object[N*2];
		for(int i=0;i<a.length;i++){
			b[i] = a[i];
		}
		a = b;
	}
	
	public Item dequeue(){
		int index = new Random().nextInt(N);
		Item item = a[index];
		a[index] = a[0];
		for(int i=0;i<N-1;i++){
			a[i] = a[i+1];
		}
		N--;
		return item;
	}
	
	//删除指定位置元素
	public Item remove(int i){
		Item item = a[i];
		for(int j=i;j<N-1;j++){
			a[i] = a[j+1];
		}
		N--;
		return item;
	}
	
	public Item sample(){
		int index = new Random().nextInt(N);
		return a[index];
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item>{
		int i = 0;
		@Override
		public boolean hasNext() {
			
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
