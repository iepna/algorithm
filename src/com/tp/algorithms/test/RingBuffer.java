package com.tp.algorithms.test;
/**
 * ���λ�����
 * @author Administrator
 *
 * @param <i>
 */
public class RingBuffer<Item> {
	private Node node;
	private Node position = node;//��λָ��
	private int N = 8192;//8192kB�����������
	
	public RingBuffer(){
		node = new Node();
		Node n = node;
		for(int i=0;i<N;i++){
			n.next = new Node();
			n = n.next;
			
		}
		n.next = node;
	}
	//д�뻺����
	public void write(Item item){
		if(position==node){
			//����������������д���ļ�
		}
		position.item = item;
		position = position.next;
	}
	private class Node{
		Node next;
		Item item;
	}
	
}
