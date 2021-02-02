package a0202_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d4_1210_Ladder1_구미_4_봉대현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1210.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			// 테케 번호
			int tn = sc.nextInt();
			int[][] map = new int[100][100];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 시작 지점찾기
			int res = 0;
			boolean flag = false;
			for (int y = 0; y < 100; y++) {
				if (flag)
					break;
				if (map[0][y] == 1) {
					int nx = 1;
					int ny = y;
					while (true) {
						if (nx == 99)
							break;
						// 좌우
						int left = ny - 1;
						int right = ny + 1;
						// 좌
						if (0 <= left && left < 100 && map[nx][left] == 1) {
							while (true) {
								if (0 <= left && map[nx][left] == 1)
									left--;
								else
									break;
							}
							ny = left + 1;
						}
						// 우
						else if (0 <= right && right < 100 && map[nx][right] == 1) {
							while (true) {
								if (right < 100 && map[nx][right] == 1)
									right++;
								else
									break;
							}
							ny = right - 1;
						}
						// 밑으로만 이동
						int down = nx + 1;
						if (down < 100 && map[down][ny] == 1) {
							nx = down;
						} else if (map[down][ny] == 2) { // 도착지점
							res = y;
							flag = true;
							break;
						}
					}
				}
			}

			System.out.println("#" + tn + " " + res);
		} // for end
	}
}
