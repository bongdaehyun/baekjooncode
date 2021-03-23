package a0323_algo;

import java.util.Scanner;

//82퍼 틀림.
public class Main_bj_1463_1로만들기 {
	static int dp[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new int[n+1];
		if(n==1) System.out.println("0");
		else if(n==2||n==3)System.out.println("1");
		else {
			dp[1]=0;
			dp[2]=1;
			dp[3]=1;
			//if 를 써야되는 이유 6인경우
			for(int i=4;i<=n;i++) {
				dp[i]= dp[i-1]+1;
				if(i%3==0)
					dp[i]=Math.min(dp[i/3]+1, dp[i]);
				if(i%2==0)
					dp[i]=Math.min(dp[i/2]+1, dp[i]);
			}
			System.out.println(dp[n]);
		}
		sc.close();

	}

}
