package a0323_algo;

import java.util.Scanner;

public class Main_bj_1149_RGB거리 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]houses=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				houses[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1;i<n;i++) {
			houses[i][0]=Math.min(houses[i-1][1],houses[i-1][2])+houses[i][0];
			houses[i][1]=Math.min(houses[i-1][0],houses[i-1][2])+houses[i][1];
			houses[i][2]=Math.min(houses[i-1][1],houses[i-1][0])+houses[i][2];
		}
		int minv=Math.min(houses[n-1][1], houses[n-1][0]);
		int ans=Math.min(houses[n-1][2],minv);
		System.out.println(ans);
		sc.close();

	}

}
