package a0412_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution_1249_보급로 {
	static int[][] map;
	static boolean vistied[][];
	static int n;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine());
			
			//맵 입력
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] s = in.readLine().split("");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(s[j]) ;
				}
			}
			
			// for(int []m:map)System.out.println(Arrays.toString(m));

			int result = Integer.MAX_VALUE;
			vistied = new boolean[n][n];
			
			ArrayDeque<int[]> q = new ArrayDeque<>();
			
			int[][] d = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(d[i], Integer.MAX_VALUE);
			}
			q.add(new int[] { 0, 0 });
			vistied[0][0] = true;
			d[0][0] = 0;

			// bfs
			while (!q.isEmpty()) {
				int cnt[] = q.poll();
				// 도착지에 도착 ,최소값과 비교하여 갱신
				if (cnt[0] == n - 1 && cnt[1] == n - 1) {
					result =Math.min(result, d[n-1][n-1]);
				}
				if(result<=d[cnt[0]][cnt[1]])
					continue;
				
				for (int k = 0; k < 4; k++) {
					int nx = cnt[0] + dx[k];
					int ny = cnt[1] + dy[k];

					if (0 <= nx && 0 <= ny && nx < n && ny < n ) {
						if ( !vistied[nx][ny] || d[nx][ny] > d[cnt[0]][cnt[1]] + map[nx][ny]) {
							d[nx][ny] = d[cnt[0]][cnt[1]] + map[nx][ny];
							q.add(new int[] { nx, ny });
							vistied[nx][ny] = true;
						}
						// for(boolean []v:vistied)System.out.println(Arrays.toString(v));
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}//for end

		in.close();

	}

}
