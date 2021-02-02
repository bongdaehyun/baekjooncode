package a0202_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d2_1954_달팽이숫자_구미_4_봉대현 {
	//우 하 좌 상
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1954.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int cnt = 1;
			// start 좌표
			int x = 0;
			int y = -1;
			// 방향
			int d = 0;
			// 반복횟수
			int count = 1;
			// 0,0 좌표 1
			int k = 0;
			while (true) {
				if (cnt == N * N + 1)
					break;
				for (int i = count; i < 2; i++) {
					for (int j = 0; j < N - k; j++) {
						x += dx[d];
						y += dy[d];
						map[x][y] = cnt++;
					}
					d++;
					if (d == 4)
						d = 0;
				}
				count = 0;
				k++;
			}
			System.out.println("#"+t);
			for (int[] a : map) {
				for (int m : a)
					System.out.print(m+" ");
				System.out.println();
			}
		} // for end

	}// main end

}
