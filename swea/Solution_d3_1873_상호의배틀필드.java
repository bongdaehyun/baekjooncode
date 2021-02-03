package a0203_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d3_1873_상호의배틀필드_구미_4_봉대현 {
	static int[] dx = { -1, 1, 0, 0 };// 상 하 좌우
	static int[] dy = { 0, 0, -1, 1 };// 상 하 좌우

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1873.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			int sx = 0;
			int sy = 0;
			int d = 0; // 0 1 2 3 -> 상 하 좌 우

			for (int i = 0; i < H; i++) {
				String row = sc.next();
				for (int j = 0; j < row.length(); j++) {
					map[i][j] = row.charAt(j);
					if (map[i][j] == '<') {
						sx = i;
						sy = j;
						d = 2;
					} else if (map[i][j] == '>') {
						sx = i;
						sy = j;
						d = 3;
					} else if (map[i][j] == 'v') {
						sx = i;
						sy = j;
						d = 1;
					} else if (map[i][j] == '^') {
						sx = i;
						sy = j;
						d = 0;
					}
				}
			}
			int m = sc.nextInt();
			String moves = sc.next();
			for (int i = 0; i < moves.length(); i++) {
				// 명령
				char command = moves.charAt(i);
				if (command == 'S')// 벽 뿌시기
				{
					// 방향
					for (int k = 0; k < 4; k++) {
						if (d == k) {
							int nx = sx;
							int ny = sy;
							while (0 <= nx && nx < H && 0 <= ny && ny < W) {
								// 강철벽 or 밖으로 나가면 아웃
								if (map[nx][ny] == '#')
									break;
								// 벽이면 평지화
								if (map[nx][ny] == '*') {
									map[nx][ny] = '.';
									break;
								}
								nx += dx[d];
								ny += dy[d];
							}
							break;
						}
					}
				} else if (command == 'U') {
					if (0 <= sx + dx[0] && sx + dx[0] < H && 0 <= sy + dy[0] && sy + dy[0] < W) {
						if (map[sx + dx[0]][sy + dy[0]] == '.') {
							map[sx][sy] = '.';
							sx += dx[0];
							sy += dy[0];
						}
					}
					map[sx][sy] = '^';
					d = 0;
				} else if (command == 'D') {
					if (0 <= sx + dx[1] && sx + dx[1] < H && 0 <= sy + dy[1] && sy + dy[1] < W) {
						if (map[sx + dx[1]][sy + dy[1]] == '.') {
							map[sx][sy] = '.';
							sx += dx[1];
							sy += dy[1];
						}
					}
					map[sx][sy] = 'v';
					d = 1;
				} else if (command == 'L') {
					if (0 <= sx + dx[2] && sx + dx[2] < H && 0 <= sy + dy[2] && sy + dy[2] < W) {
						if (map[sx + dx[2]][sy + dy[2]] == '.') {
							map[sx][sy] = '.';
							sx += dx[2];
							sy += dy[2];
						}
					}
					map[sx][sy] = '<';
					d = 2;
				} else if (command == 'R') {
					if (0 <= sx + dx[3] && sx + dx[3] < H && 0 <= sy + dy[3] && sy + dy[3] < W) {
						if (map[sx + dx[3]][sy + dy[3]] == '.') {
							map[sx][sy] = '.';
							sx += dx[3];
							sy += dy[3];
						}
					}
					map[sx][sy] = '>';
					d = 3;
				}
			}
			System.out.print("#" + t + " ");
			for (char[] c : map) {
				for (char a : c)
					System.out.print(a);
				System.out.println();
			}
		} // for end

	}

}
