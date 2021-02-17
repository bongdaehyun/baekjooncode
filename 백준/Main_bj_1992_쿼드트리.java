package a0217_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_1992_쿼드트리_구미_4_봉대현 {
	static int map[][];
	private static int n;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		n = stoi(in.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = in.readLine();
			for (int j = 0; j < s.length(); j++)
				map[i][j] = s.charAt(j) - '0';
		}
		// for(int []m:map)System.out.println(Arrays.toString(m));
		divide(n, 0, 0);
		System.out.println(sb.toString());
		in.close();
	}

	static void divide(int n, int x, int y) {
		if (n == 1) {
			sb.append(map[x][y]);
			return;
		} else {
			boolean flag = false;
			// 모든 숫자 검사
			int check = map[x][y];
			loop: for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					if (check != map[i][j]) {
						flag = true;// 숫자가 달라서 분할해야됨
						break loop;
					}
				}
			}
			if (flag) { //4사분면으로 분할해서 탐색
				sb.append("("); //분할 되면 ( 괄호 시작
				divide(n / 2, x, y);
				divide(n / 2, x, y + n / 2);
				divide(n / 2, x + n / 2, y);
				divide(n / 2, x + n / 2, y + n / 2);
				sb.append(")"); //분할 되면 ) 닫기
			} else { //모든 숫자가 같다면 바로 출력
				sb.append(check);
				return;
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
