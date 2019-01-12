package com.tp.algorithms.base;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;//指向最早添加的节点的链接
	private Node last;//指向最近添加的节点的链接
	private int N;//队列中的元素数量
	private class Node{
		//定义了节点的嵌套类
		Item item;
		Node next;
	}
	//向表尾添加元素
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())  first = last;
		else	oldlast.next = last;
		N++;
	}
	//从表头删除元素
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())	last = null;
		N--;
		return item;
		
	}
	//队列是否为空
	public boolean isEmpty(){
		return first==null;
		
	}
	//队列中的元素数量
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
