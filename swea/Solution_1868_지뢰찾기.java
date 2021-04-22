package a0422_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_1868_지뢰찾기 {
	// 8방향탐색
	static int dx[] = { 0, 1, -1, 0, -1, -1, 1, 1 };
	static int dy[] = { 1, 0, 0, -1, -1, 1, 1, -1 };
	static int n, ans, mCnt[][];
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine());
			map = new char[n][n];
			mCnt = new int[n][n];
			ans = 0;
			for (int i = 0; i < n; i++) {
				char temp[] = in.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = temp[j];
				}
			}
			
			// 주변 지뢰 개수 구하기
			getCountboom();
			//for(int []m:mCnt)System.out.println(Arrays.toString(m));
			// 주변에 지뢰가 없는 곳부터 즉 0인 부분부터 클릭
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 주변에 지뢰가 없고 현위치가 지뢰부분이 아니라면
					if (mCnt[i][j] == 0 && map[i][j] != '*') {
						doclick(i, j);
						ans++;
					}
				}
			}
			// 남아있는 지뢰터트리기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 주변에 지뢰가 있고 현위치가 지뢰가아닌부분
					if (mCnt[i][j] > 0 && map[i][j] != '*') {
						ans++;
					}
				}
			}

			System.out.println("#" + t + " " + ans);
		}
		in.close();
	}

	static void doclick(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		mCnt[x][y] = -1; // 방문 체크

		while (!q.isEmpty()) {
			int cnt[] = q.poll();

			for (int d = 0; d < 8; d++) {
				int nx = cnt[0] + dx[d];
				int ny = cnt[1] + dy[d];
				if (0 > nx || ny < 0 || nx == n || ny == n)
					continue;
				if (mCnt[nx][ny] == -1)
					continue;
				if (map[nx][ny] == '*')
					continue;

				// 주변에 0인부분은 연쇄폭발
				if (mCnt[nx][ny] == 0)
					q.add(new int[] { nx, ny });

				mCnt[nx][ny] = -1;// 방문체크
			}
		}
	}

	static void getCountboom() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 클릭할 수 있는 곳의 주변 지뢰 개수
				if (map[i][j] == '.') {
					int count = 0;
					for (int d = 0; d < 8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						if (0 > nx || ny < 0 || nx == n || ny == n)
							continue;
						if (map[nx][ny] == '*') {
							count++;
						}
					}
					mCnt[i][j] = count;
				}
			}
		}

	}

}
