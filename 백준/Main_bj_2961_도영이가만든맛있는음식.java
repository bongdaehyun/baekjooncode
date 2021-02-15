package a0215_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_bj_2961_도영이가만든맛있는음식 {

	private static int N;
	static ArrayList<int []>ary;
	static int []pick;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		N=stoi(in.readLine());
		ary=new ArrayList<>();
		pick=new int[N];
		res=Integer.MAX_VALUE;
		for(int n=0;n<N;n++) {
			String s[]=in.readLine().split(" ");
			ary.add(new int[] {stoi(s[0]),stoi(s[1])});
		}
		for(int k=1;k<=N;k++) {//재료 선택 1,2,3,~~N까지 모든 조합확인
			combi(0,0,k);
		}
		System.out.println(res);
	}
	static void combi(int cnt,int start,int end) {
		if(cnt==end) {
			int s=1;
			int w=0;
			for(int i=0;i<end;i++) {
				int []temp=ary.get(pick[i]);
				s*=temp[0];
				w+=temp[1];
			}
			res=Math.min(res, Math.abs(s-w));
			return;
		}
		for(int i=start;i<N;i++) {
			pick[cnt]=i;
			combi(cnt+1,i+1,end);
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
