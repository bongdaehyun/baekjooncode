package algo;
import java.util.*;
public class Main_bj_11727_2n타일링2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int dp[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			if(i==1) {
				dp[1]=1;
			}else if(i==2) {
				dp[2]=3;
			}else {
				dp[i]=(dp[i-1]+2*dp[i-2])%10007;
			}
		}
		System.out.println(dp[n]);
	}
}
