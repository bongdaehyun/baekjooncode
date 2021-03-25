package a0325_algo;

import java.util.Arrays;
import java.util.Scanner;
public class Solution_d3_최장증가부분순열{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
		int n=sc.nextInt();
		int []arr=new int[n];
		int []LIS=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		int max=0;
		Arrays.fill(LIS, 1);
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]&&LIS[i]<LIS[j]+1) {
					LIS[i]=LIS[j]+1;
				}
			}
			if(max<LIS[i])max=LIS[i];
		}
		System.out.println("#"+t+" "+max);
        }
	}

}

