package a0208_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 
4
3 45
20 20 20
6 10
1 2 5 8 9 11
4 100
80 80 60 60
4 20
10 5 10 16
 */

public class Solution_d3_9229_한빈이와SpotMart_구미_4_봉대현 {
	static int n;
	static int m;
	static int maxn;
	static int[]snack;
	//몇개 중 2개의 과자를 선택해야되므로 조합
	static void combi(int cnt,int start,int w) {
		if(cnt==2) {
			if(w>m)
				return;
			maxn=Math.max(maxn, w);
			return;
		}
		
		for(int i=start;i<n;i++) {
			combi(cnt+1,i+1,w+snack[i]);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String []s=in.readLine().split(" ");
			n= Integer.parseInt(s[0]); //과자 개수
			m= Integer.parseInt(s[1]);//제한 무게
			snack=new int[n]; //과자 무게 배열
			String s1[]=in.readLine().split(" ");
			for(int i=0;i<n;i++)
				snack[i]=Integer.parseInt(s1[i]);
			maxn=-1;
			combi(0,0,0);
			System.out.println("#"+t+" "+maxn);
		}
		in.close();
	}

}
