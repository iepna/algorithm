package com.tp.algorithms.test;

import java.io.File;
import java.util.Scanner;

import com.tp.algorithms.base.Queue;

public class FileLists {
	public static void main(String[] args) {
		Queue<File> q = new Queue<File>();
		//输入文件夹
		System.out.println("请输入文件夹：");
		String s = new Scanner(System.in).nextLine();
		File dir = new File(s);
		fileList(dir,q);
		
	}

	private static void fileList(File dir ,Queue q) {
		if(dir.exists()){
			File[] lf = dir.listFiles();
			for(File f:lf){
				q.enqueue(f);
			}
		}
		while(!q.isEmpty()){
			File file =  (File) q.dequeue();
			if(file.isFile()){
				System.out.println(file);
			}else{
				fileList(file,q);
			}
		}
		
		
	}
}
