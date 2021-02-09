package a0209_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_bj_2563_색종이_구미_4_봉대현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		
		int [][]map=new int[100][100]; //가로 세로 크기 100 정사각형 도화지
		
		for(int i=0;i<n;i++) { //색종이 입력
			String s[]=in.readLine().split(" ");
			int x= Integer.parseInt(s[0]);
			int y= Integer.parseInt(s[1]);
			
			for(int j=x;j<x+10;j++) {
				for(int k=y;k<y+10;k++)
					map[j][k]+=1;
			}
		}
		int sum=0;
		for(int j=0;j<100;j++) {
			for(int k=0;k<100;k++)
			{
				if(map[j][k]>=1)
					sum+=1;
			}
		}
		//for(int []m:map) System.out.println(Arrays.toString(m));
		System.out.println(sum);
		in.close();
	}

}
