import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_16927_배열돌리기2 {

	private static int[][] map;

	// 반시계 배열에 넣기 위해선 시계방향으로 탐색한뒤 뒤에다가 마지막 원소에
	// 시작 원소를 넣어주면 된다?
	static int dx[] = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int dy[] = { 1, 0, -1, 0 };

	private static int move;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[] = in.readLine().split(" ");
		int r = stoi(s[0]);
		int c = stoi(s[1]);
		move = stoi(s[2]);

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			String s1[] = in.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				map[i][j] = stoi(s1[j]);
			}
		}

		int mins = Math.min(r, c);

		int sr = r;
		int sc = c;
		for (int k = 0; k < mins / 2; k++) {
			int size = 2 * (r - k * 2) + 2 * (c - k * 2) - 4;
			rotate(k, k, sr--, sc--, size);
		}

		for (int m[] : map) {
			for (int a : m)
				System.out.print(a + " ");
			System.out.println();
		}
	}

	static void rotate(int sx, int sy, int x, int y, int size) {
		for (int s = 0; s < move % size; s++) {
			// 돌려지는 좌표 탐색
			int k = 0;
			int kx = sx;
			int ky = sy;
			int temp = map[sx][sy];
			while (true) {
				int nx = kx + dx[k];
				int ny = ky + dy[k];
				if (sx == nx && sy == ny)
					break;
				if (nx > x - 1 || ny > y - 1 || nx < sx || ny < sy) {
					k += 1;
					continue;
				}
				map[kx][ky] = map[nx][ny];
				kx += dx[k];
				ky += dy[k];

				// System.out.println(nx + " " + ny);
			}
			map[sx + 1][sy] = temp;
		}
	}
}
