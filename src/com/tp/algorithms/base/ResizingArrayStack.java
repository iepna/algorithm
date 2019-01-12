package com.tp.algorithms.base;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];//ջԪ��
	private int N = 0;		//Ԫ������
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int max){
		Item[] item = (Item[])new Object[max];
		for(int i=0;i<N;i++){
			item[i] = a[i];
		}
		a = item;
	}
	
	public void push(Item item){
		//��Ԫ�����ӵ�ջ��
		if(N==a.length) resize(2*a.length);
		a[N++] = item;
	}
	
	public Item pop(){
		//��ջ��ɾ��Ԫ��
		Item item = a[--N];
		a[N] = null;//�����������
		if(N>0&&N==a.length/4) resize(a.length/2);
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	private class ReverseArrayIterator implements Iterator<Item>{
		//֧�ֺ���ȳ�����
		private int i = N;
		@Override
		public boolean hasNext() {
			
			return i>0;
		}

		@Override
		public Item next() {
			
			return a[--i];
		}
		public void remove(){}
	}
}