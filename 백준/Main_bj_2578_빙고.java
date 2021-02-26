package algo;

import java.util.Scanner;

public class Main_bj_2578_빙고 {

	private static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				map[i][j] = sc.nextInt();
		int call[] = new int[25];
		int cnt=1;
		for (int i = 0; i < 25; i++) {
			call[i] = sc.nextInt();
			if(solve(call[i]))
			{
				System.out.println(cnt);
				return;
			}
			cnt++;
		}
		sc.close();
	}

	private static boolean solve(int c) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (c == map[x][y]) {
					map[x][y] = 0;
					if(call())
						return true;
				}
			}
		}
		return false;
	}

	private static boolean call() {
		// 행 열 대각선 검사
		int line = 0;
		int count = 0;

		// 행
		for (int i = 0; i < 5; i++) {
			count=0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0)
					count++;
				if (count == 5) {
					line++;
					count = 0;
				}
			}
		}
		// 열
		for (int i = 0; i < 5; i++) {
			count=0;
			for (int j = 0; j < 5; j++) {
				if(map[j][i]==0)
					count++;
				if(count==5) {
					line++;
					count=0;
				}
			}
		}
		//왼쪽 대각선 \
		count=0;
		for (int i = 0; i < 5; i++) {
				if(map[i][i]==0)
					count++;
				if(count==5) {
					line++;
					count=0;
				}
		}
		//오른쪽 대각선 /
		count=0;
		for (int i = 0; i < 5; i++) {
			
			if(map[i][4-i]==0)
				count++;
			if(count==5) {
				line++;
				count=0;
			}
			
		}
		//==3으로하면 2->4개일때 빙고를 잡지못한다.
		return line>=3?true:false;
	}
}
