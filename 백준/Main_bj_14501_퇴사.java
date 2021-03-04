package a_6weeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_14501_퇴사 {

	public static void main(String[] args) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());//최대 15
		
		int dp[]=new int[n+6];//상담일수가 5일이 최대이므로 넉넉 
		int time[]=new int[n+6];
		int day[]=new int[n+6];
		int max=Integer.MIN_VALUE;//최대수입
		for(int i=1;i<=n;i++) {//1일부터 
			StringTokenizer st=new StringTokenizer(in.readLine());
			time[i]=Integer.parseInt(st.nextToken());
			day[i]=Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<=n+1;i++) {//1일~n일까지
			dp[i]=Math.max(max,dp[i]);//최대수입과 비교
			//움직이면서 얻은 최대수익과 이전에 움직이는 것에 대한 비교
			dp[time[i]+i]=Math.max(dp[time[i]+i],dp[i]+day[i] );
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
		in.close();
	}

}
