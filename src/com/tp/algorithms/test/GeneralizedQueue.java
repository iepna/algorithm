package com.tp.algorithms.test;
/**
 * 泛型一般队列
 * @author Administrator
 *
 * @param <Item>
 */
public class GeneralizedQueue<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
		Node prev;
	}
	
	public void insert(Item x){
		if(N==0){
			first = last = new Node();
			last.item = x;
		}else{
			Node node = new Node();
			last.next = node;
			last = node;
			last.item = x;
		}
		N++;
	}
	public Item delete(int k){
		Node node = first;
		for(int i=0;i<k;i++){
			node = node.next;
		}
		node.next.prev = node.prev;
		node.prev.next = node.next;
		return node.item;
	}
	public boolean isEmpty(){
		return N==0;
	}
}
