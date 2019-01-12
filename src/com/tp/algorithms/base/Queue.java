package com.tp.algorithms.base;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;//ָ��������ӵĽڵ������
	private Node last;//ָ�������ӵĽڵ������
	private int N;//�����е�Ԫ������
	private class Node{
		//�����˽ڵ��Ƕ����
		Item item;
		Node next;
	}
	//���β���Ԫ��
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())  first = last;
		else	oldlast.next = last;
		N++;
	}
	//�ӱ�ͷɾ��Ԫ��
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())	last = null;
		N--;
		return item;
		
	}
	//�����Ƿ�Ϊ��
	public boolean isEmpty(){
		return first==null;
		
	}
	//�����е�Ԫ������
	public int size(){
		return N;
		 
	}
	@Override
	public Iterator<Item> iterator() {
		
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Item>{
		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current.next!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		
	}
}
