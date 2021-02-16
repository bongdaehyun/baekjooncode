package a0216_algo;

import java.util.Scanner;

public class Main_bj_2839_설탕배달 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=0;
		while(n>0) {
			if(n%5!=0 ) {
				n-=3;
				if(n<0) {
					count=-1;
					break;
				}
				count+=1;
			}
			else if(n%5==0){
				n-=5;
				count+=1;
			}
			else {
				count=-1;
				break;
			}
		}
	
		System.out.println(count);
		sc.close();
	}

}
