package com.tp.algorithms.test;

import com.tp.algorithms.base.ResizingArrayStack;

/**
 * 文本缓冲区
 * @author Administrator
 *
 */

public class Buffer {
	//数组定义的栈，存放字符
	private ResizingArrayStack<Character> stack = new ResizingArrayStack<>();
	//光标位置
	private int flag;
	//光标位置插入字符
	public void insert(char c){
		stack.push(c);
		flag = stack.size();
	}
	//删除并返回光标位置的字符
	public char delete(){
		char c = stack.pop();
		flag = stack.size();
		return c;
	}
	//将光标向左移动k个位置
	public void left(int k){
		if(k<=flag)
	}
	//将光标向右移动k个位置
	public void right(int k) {
		
	}
	
	//缓冲区的字符数量
	public int size(){
		return stack.size();
		
	}
}
