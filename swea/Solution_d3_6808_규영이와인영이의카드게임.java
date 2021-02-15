package a0215_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d3_6808_규영이와인영이의카드게임 {
	static int total=362880;
	static boolean []sel;
	static int [] pick;
	static int count;
	static int [] gyu;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_6808.txt"));
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int T=stoi(in.readLine());
		for(int t=1;t<=T;t++) {
			count=0;
			pick=new int[9];
			gyu=new int[9];
			sel=new boolean[19]; //0인덱스는 더미
			String s[]=in.readLine().split(" ");
			//규영이가 뽑은카드
			for(int i=0;i<s.length;i++) {
				sel[stoi(s[i])]=true;
				gyu[i]=stoi(s[i]);
			}
			permutation(0);
			System.out.println("#"+t+" "+count+" "+(total-count));
		}
		in.close();
	}
	static void permutation(int cnt) {
		if(cnt==9) {
			//한라운드에는 한장씩 카드!
			//높은수가 적힌 카드를 낸사람은 두카드에 적힌 수의합만큼 점수
			//낮은 수가 적힌 카드는 아무런 점수 x
			int gyo2=0;
			int in=0;
			for(int i=0;i<9;i++) {//9라운드
				if(gyu[i]>pick[i]) {
					gyo2+=gyu[i]+pick[i];
				}else if(gyu[i]<pick[i]) {
					in+=gyu[i]+pick[i];	
				}
			}
			if(gyo2>in)
				count++;
			return;
		}
		for(int i=1;i<=18;i++) {
			if(sel[i])continue;
			pick[cnt]=i;
			sel[i]=true;
			permutation(cnt+1);
			sel[i]=false;
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
