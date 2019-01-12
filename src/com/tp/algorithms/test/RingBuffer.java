package com.tp.algorithms.test;
/**
 * 环形缓冲区
 * @author Administrator
 *
 * @param <i>
 */
public class RingBuffer<Item> {
	private Node node;
	private Node position = node;//定位指针
	private int N = 8192;//8192kB缓存性能最好
	
	public RingBuffer(){
		node = new Node();
		Node n = node;
		for(int i=0;i<N;i++){
			n.next = new Node();
			n = n.next;
			
		}
		n.next = node;
	}
	//写入缓冲区
	public void write(Item item){
		if(position==node){
			//缓冲区已满将数据写入文件
		}
		position.item = item;
		position = position.next;
	}
	private class Node{
		Node next;
		Item item;
	}
	
}
