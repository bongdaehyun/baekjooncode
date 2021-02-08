package a0208_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

1
5 1000
100 200
300 500
250 300
500 1000
400 400

 */
public class Solution_d3_5215_햄버거다이어트_구미_4_봉대현 {
	static int score[];
	static int kal[];
	static int Maxn;
	static int L;
	static int n;
	//끝까지 다확인하기때문에 dfs??
	static void dfs(int cnt,int s,int k) {
		if(k>L)//제한 칼로리 이상이면 return
			return;
		if(cnt==n) {//모두다 선택했을 때
			Maxn=Math.max(Maxn, s);
			return;
		}
		//선택
		dfs(cnt+1,s+score[cnt],k+kal[cnt]);
		//비선택
		dfs(cnt+1,s,k);
		
	}
	//부분 집합 문제 
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String s[]=in.readLine().split(" ");
			n= Integer.parseInt(s[0]);
			L= Integer.parseInt(s[1]);
			score=new int[n];
			kal=new int[n];
			for(int i=0;i<n;i++) {
				String s1[]=in.readLine().split(" ");
				score[i]=Integer.parseInt(s1[0]);
				kal[i]=Integer.parseInt(s1[1]);
			}
			Maxn=0;
			dfs(0,0,0);
			System.out.println("#"+t+" "+Maxn);
		}
		in.close();
	}

}
