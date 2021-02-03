package a0203_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d2_2001_파리퇴치_구미_4_봉대현 {
	static int map[][];
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_2001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			map=new int[N][N];
			int Maxn=0;
			
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					map[i][j]=sc.nextInt();
			//for(int []m:map)System.out.println(Arrays.toString(m));
			
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					Maxn=Math.max(Maxn, box(i,j,M));
				}
			}
			System.out.println("#" + t + " "+Maxn);
		}
		sc.close();
	}
	static int box(int x,int y,int M) {
		int res=0;
		
		for(int i=x;i<x+M;i++) {
			for(int j=y;j<y+M;j++) {
				res+=map[i][j];
			}
		}
		return res;
	}
}
