package com.tp.algorithms.base;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node first;//栈顶（最近添加的元素）
	private int N;//元素个数
	
	private class Node {
		//定义节点嵌套
		Item item;
		Node next;
	}
	//添加一个元素
	public void push(Item item){
		//向栈顶添加元素
		Node oldfirst = first;
		first =new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	//删除最后添加的元素
	public Item pop(){
		//删除栈顶元素
		Item item = first.item;
		first = first.next;
		N--;
		return item;
		
	}
	//栈是否为空
	public boolean isEmpty(){
		return first==null;
		
	}
	//栈中的元素数量
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
