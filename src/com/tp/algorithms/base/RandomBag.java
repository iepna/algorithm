package com.tp.algorithms.base;

import java.util.Iterator;
import java.util.Random;

public class RandomBag<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[10];
	private int N;
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item){
		if(N<a.length)	a[N] = item;
		else {
			resize();
			a[N] = item;
		}
		N++;
	}
	
	private void resize() {
		Item[] item = (Item[]) new Object[N*2];
		for(int i=0;i<N;i++){
			item[i] = a[i];
		}
		a = item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomIterator();
	}
	private class RandomIterator implements Iterator<Item>{
		int current = 0;
		public RandomIterator(){
			for(int i=0;i<N;i++){
				int index = new Random().nextInt(N);
				Item item = a[i];
				a[i] = a[index];
				a[index] = item;
			}
		}
		@Override
		public boolean hasNext() {
			
			return current<N-1;
		}

		@Override
		public Item next() {
			Item item = a[current];
			current++;
			return item;
		}
		
	}

}
