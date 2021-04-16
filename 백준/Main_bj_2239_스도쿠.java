package a0416_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_bj_2239_스도쿠 {

	static int map[][];
	static ArrayList<int[]> zerolist = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String s[] = in.readLine().split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 0)
					zerolist.add(new int[] { i, j });
			}
		}
		dfs(0);
		showmap();
		in.close();

	}

	static void dfs(int cnt) {
		if (cnt == zerolist.size()) {
			return;
		}
		int i=zerolist.get(cnt)[0];
		int j=zerolist.get(cnt)[1];
		// 숫자가 아직채워지지 않은 칸
		if (map[i][j] == 0) {
			// 1~9까지의 숫자 넣어보기
			for (int n = 1; n <= 9; n++) {
				if (isrow(i, j, n) && iscol(i, j, n) && ischeck3by3(i, j, n)) {
					map[i][j] = n;
					dfs(cnt + 1);
					if(checkmap())
						return;
					map[i][j] = 0;
				}
			}

		}
	}

	// 행에 들어갈 숫자의 중복 체크
	static boolean isrow(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == num)
				return false;
		}
		return true;
	}

	// 열에 들어갈 숫자의 중복 체크
	static boolean iscol(int x, int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == num)
				return false;
		}
		return true;
	}

	// 9개의 구역으로 나눠서 비교
	static boolean ischeck3by3(int x, int y, int num) {
		/*
		int sx = 0, sy = 0;
		
		// 1번 구역
		if (x >= 0 && x < 3 && y >= 0 && y < 3) {
			sx = 0;
			sy = 0;
			
		} else if (x >= 0 && x < 3 && y >= 3 && y < 6) {
			sx = 0;
			sy = 3;
			
		} else if (x >= 0 && x < 3 && y >= 6 && y < 9) {
			sx = 0;
			sy = 6;
			
		} else if (x >= 3 && x < 6 && y >= 0 && y < 3) {
			sx = 3;
			sy = 0;
			
		} else if (x >= 3 && x < 6 && y >= 3 && y < 6) {
			sx = 3;
			sy = 3;
			
		} else if (x >= 3 && x < 6 && y >= 6 && y < 9) {
			sx = 3;
			sy = 6;
			
		} else if (x >= 6 && x < 9 && y >= 0 && y < 3) {
			sx = 6;
			sy = 0;
			
		} else if (x >= 6 && x < 9 && y >= 3 && y < 6) {
			sx = 6;
			sy = 3;
			
		} else {
			sx = 6;
			sy = 6;
			
		}*/
		
		int sx=x/3*3;
		int sy=y/3*3;
		
		for (int i = sx; i < sx+3; i++) {
			for (int j = sy; j < sy+3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

	// 0이없다면 종료
	static boolean checkmap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static void showmap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
