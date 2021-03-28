package a_9weeks;

import java.util.*;
import java.io.*;

public class Main_bj_11066_파일합치기 {
	static int []cost;
	static int n,ans;
	static int [][]dp;
	static int []sum;
	static final int max_value=Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		StringTokenizer st=null;
		for(int t=0;t<T;t++) {
			n=Integer.parseInt(in.readLine());
			st=new StringTokenizer(in.readLine());
			cost=new int[n+1];
			sum=new int[n+1];
			dp=new int[n+1][n+1];
			for(int i=1;i<=n;i++) {
				cost[i]=Integer.parseInt(st.nextToken());//비용 입력
				sum[i]=sum[i-1]+cost[i];//누적합을 구하기
				for(int j=1;j<=n;j++) {
					dp[i][j]=max_value;
				}
			}
			
//			System.out.println(solve(1,n));
		}
		
		in.close();
	}
	/*static int solve(int start,int end) {
		//자기 자신인 경우 합치는 비용 x
		if(start>=end) {
			return 0;
		}
		//이웃한 경우
		if(end==start+1) {
			return cost[start]+cost[end];
		}
		if(dp[start][end]<max_value) {
			return dp[start][end];
		}
		
		
	}
	*/
}
