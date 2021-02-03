package a0203_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d3_2805_농작물수확하기_구미_4_봉대현 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_2805.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=sc.nextInt();
			int [][]map=new int[N][N];
			for(int i=0;i<N;i++) {
				String s=sc.next();
				for(int j=0;j<s.length();j++)
					map[i][j]=Character.getNumericValue(s.charAt(j));
			}
			//for(int []k:map)System.out.println(Arrays.toString(k));
			int sx=0;
			int sy=N/2;
			int sum=0;
			//위쪽
			for(int k=1;k<=N;k+=2) {
				int x=sx;
				int y=sy;
				for(int m=0;m<k;m++) {
					sum+=map[x][y];
					y+=1;
				}
				sx+=1;
				sy-=1;
			}
			//커서이동
			sy+=2;
			//아래쪽
			for(int k=N-2;k>=1;k-=2) {
				int x=sx;
				int y=sy;
				for(int m=0;m<k;m++) {
					sum+=map[x][y];
					y+=1;
				}
				sx+=1;
				sy+=1;
			}
			System.out.println("#" + t + " "+sum);
			
		} // for end

	}

}
