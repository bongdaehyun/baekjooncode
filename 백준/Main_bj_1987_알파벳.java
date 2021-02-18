package a0218_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1987_알파벳_구미_4_봉대현 {
	static int[] dx = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static char[][] map;
	static int R, C, ans = 0;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[91];
		// A :65 B:66 ~Z:90
		map = new char[R][];
		for (int i = 0; i < R; i++)
			map[i] = in.readLine().toCharArray();
		visited[map[0][0]] = true;
		// System.out.println(visited[map[0][0]]);
		ans += 1;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	static void dfs(int r, int c, int cnt) {
		for (int d = 0; d < 4; d++) {
			int nx = r + dx[d];
			int ny = c + dy[d];
			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				if (visited[map[nx][ny]]) {
					if (cnt > ans)
						ans = cnt;
					continue;
				}

				visited[map[nx][ny]] = true;
				dfs(nx, ny, cnt + 1);
				visited[map[nx][ny]] = false;
			}
		}

	}
}
