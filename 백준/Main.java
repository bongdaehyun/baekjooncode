package com.ssafy.camp.hello;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []a=new int[n];
		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		boolean check=true;
		for(int i=0;i<a.length;i++) {
			if(i%2==a[i]%2) {
				check=false;
			}
		}
		System.out.println( check ? "YES":"NO");
	}
}
