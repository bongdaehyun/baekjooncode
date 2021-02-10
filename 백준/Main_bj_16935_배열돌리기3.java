package a0210_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_16935_배열돌리기3_구미_4_봉대현 {

	static int[][] map;
	private static int r;
	private static int c;
	static boolean flag;
	//전역으로 쓸때 제대로 초기화를 해주자 안그러면 헷갈린다..
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[] = in.readLine().split(" ");
		r = stoi(s[0]);
		c = stoi(s[1]);
		map = new int[r][c];
		// 연산 횟수
		int R = stoi(s[2]);
		for (int i = 0; i < r; i++) {
			String s1[] = in.readLine().split(" ");
			for (int j = 0; j < c; j++)
				map[i][j] = stoi(s1[j]);
		}
		String s2[] = in.readLine().split(" ");
		for (int i = 0; i < R; i++) {
			
			switch (stoi(s2[i])) {
			case 1: // 배열 상하 반전
				one();
				break;
			case 2:// 배열 좌우 반전
				two();
				break;
			case 3: // 오른쪽 90도 회전
				three();
				break;
			case 4:// 왼쪽 90도 회전
				four();
				break;
			case 5:// 그룹 시계
				five();
				break;
			case 6:// 그룹 반시계
				six();
				break;

			}
		}
		for (int[] a : map) {
			for (int b : a)
				System.out.print(b + " ");
			System.out.println();
		}
		in.close();
	}

	private static void six() {
		int copy[][]=new int [r][c];
		//1사분면 ->3사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i+r/2][j]=map[i][j];
			}
		}
		//3사분면 -> 4사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i+r/2][j+c/2]=map[i+r/2][j];
			}
		}
		//4사분면 ->2사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i][j+c/2]=map[i+r/2][j+c/2];
			}
		}
		//2사분면 ->1사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i][j]=map[i][j+c/2];
			}
		}
		map=copy;
		
	}

	private static void five() {
		//1->2->4->3
		
		int copy[][]=new int [r][c];
		//1사분면 ->2사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i][j+c/2]=map[i][j];
			}
		}
		//2사분면 -> 4사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i+r/2][j+c/2]=map[i][j+c/2];
			}
		}
		//4사분면 ->3사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i+r/2][j]=map[i+r/2][j+c/2];
			}
		}
		//3사분면 ->1사분면
		for(int i=0;i<r/2;i++) {
			for(int j=0;j<c/2;j++) {
				copy[i][j]=map[i+r/2][j];
			}
		}
		map=copy;
	}

	private static void four() {
		int [][]copyary=new int [c][r];
		
		int cnt=copyary[0].length-1;
		for(int j=map.length-1;j>=0;j--) {
			int x=0;
			for(int k=map[0].length-1;k>=0;k--) {
				copyary[x++][cnt]=map[j][k];
			}
			cnt--;
		}
		map=copyary;
		r=map.length;
		c=map[0].length;
	}

	static void one() {
		int i = 0;
		int j = r - 1;
		while (i < j) {
			int[] temp = map[i];
			map[i] = map[j];
			map[j] = temp;
			i++;
			j--;
		}
	}

	static void two() {

		for (int i = 0; i < r; i++) {
			int left = 0;
			int right = c - 1;
			while (left < right) {
				int temp = map[i][left];
				map[i][left] = map[i][right];
				map[i][right] = temp;
				left++;
				right--;
			}

		}

	}

	static void three() {
		int [][]copyary=new int [c][r];

		int k=0;
		for (int i = 0; i <copyary.length; i++) { //y
			int cnt=0;
			int[] temp=new int[r];
			for(int j=copyary[0].length-1;j>=0;j--) {//x
				temp[cnt++]=map[j][i];
			}
			copyary[k++]=temp;
		}
		map=copyary;
		r=map.length;
		c=map[0].length;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
