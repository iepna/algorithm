package com.tp.algorithms.test;

import com.tp.algorithms.base.ResizingArrayStack;

/**
 * �ı�������
 * @author Administrator
 *
 */

public class Buffer {
	//���鶨���ջ������ַ�
	private ResizingArrayStack<Character> stack = new ResizingArrayStack<>();
	//���λ��
	private int flag;
	//���λ�ò����ַ�
	public void insert(char c){
		stack.push(c);
		flag = stack.size();
	}
	//ɾ�������ع��λ�õ��ַ�
	public char delete(){
		char c = stack.pop();
		flag = stack.size();
		return c;
	}
	//����������ƶ�k��λ��
	public void left(int k){
		if(k<=flag)
	}
	//����������ƶ�k��λ��
	public void right(int k) {
		
	}
	
	//���������ַ�����
	public int size(){
		return stack.size();
		
	}
}
