package com.tp.algorithms.base;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node first;//ջ���������ӵ�Ԫ�أ�
	private int N;//Ԫ�ظ���
	
	private class Node {
		//����ڵ�Ƕ��
		Item item;
		Node next;
	}
	//���һ��Ԫ��
	public void push(Item item){
		//��ջ�����Ԫ��
		Node oldfirst = first;
		first =new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	//ɾ�������ӵ�Ԫ��
	public Item pop(){
		//ɾ��ջ��Ԫ��
		Item item = first.item;
		first = first.next;
		N--;
		return item;
		
	}
	//ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return first==null;
		
	}
	//ջ�е�Ԫ������
	public int size(){
		return N;
		
	}
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	private class StackIterator implements Iterator<Item>{
		Node current = first;

		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
}
