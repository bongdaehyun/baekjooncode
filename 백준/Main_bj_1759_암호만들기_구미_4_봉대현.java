package a0316_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_1759_암호만들기_구미_4_봉대현 {

	static String[] alpha;
	static boolean[] pick;
	static int L,C;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pick = new boolean[C];
		
		alpha = in.readLine().split(" ");
		//정렬
		Arrays.sort(alpha);
		//System.out.println(Arrays.toString(alpha));
		//스타트, 선택된 개수 ,자음 ,모음
		dfs(0,0,0,0);
	}

	static void dfs(int start,int cnt, int ja, int mo) {
		//자음이 2개이상 모음이 1개 이상
		if(cnt==L&&ja>=2&&mo>=1) {
			for(int i=0;i<C;i++) {
				if(pick[i])
					System.out.print(alpha[i]);
			}
			System.out.println();
			return;
		}
		for(int i=start;i<C;i++) {
			pick[i]=true;//선택
			if(!check(alpha[i]))
				ja+=1;
			if(check(alpha[i]))
				mo+=1;
			dfs(i+1,cnt+1,ja,mo);
			if(!check(alpha[i]))
				ja-=1;
			if(check(alpha[i]))
				mo-=1;
			pick[i]=false;//비선택
		}
	}
	static boolean check(String c) {
		//모음
		if(c.equals("a")||c.equals("e")||c.equals("i")||c.equals("o")||c.equals("u"))
			return true;
		else
			return false;
	}
}
