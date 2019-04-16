package com.sts.test;

public class demo1 {
	
	public static long run(int n){
		if(n > 1){
			return (n * run(n - 1));
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(run(6));
		
	}

}
