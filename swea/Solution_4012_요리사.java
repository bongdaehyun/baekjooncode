package a0219_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_4012_요리사 {
	static int[][] map;
	static int n, ans;
	static boolean visited[];// 식재료를 나누는 기준

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_13458.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = stoi(in.readLine());
		for (int t = 1; t <= T; t++) {
			n = stoi(in.readLine());// 배열크기
			map = new int[n][n]; // 시너지 표
			// 식재료 시너지 입력
			for (int i = 0; i < n; i++) {
				String s[] = in.readLine().split(" ");
				for (int j = 0; j < n; j++)
					map[i][j] = stoi(s[j]);
			}
			visited = new boolean[n];
			ans = Integer.MAX_VALUE;
			combi(0, 0);
			System.out.println("#" + t + " " + ans);
		}
		in.close();
	}

	private static int cal() {
		ArrayList<Integer> alist = new ArrayList<>();
		ArrayList<Integer> blist = new ArrayList<>();

		// 음식 별 식재료 나누기
		for (int i = 0; i < n; i++) {
			if (visited[i])
				alist.add(i);
			else
				blist.add(i);
		}
		int asum = 0;// alist 시너지 합
		int bsum = 0;// blist 시너지 합

		// 시너지 합 구하기
		for (int i = 0; i < alist.size(); i++) {
			for (int j = i; j < blist.size(); j++) {
				asum+=map[alist.get(i)][alist.get(j)]+map[alist.get(j)][alist.get(i)];
				bsum+=map[blist.get(i)][blist.get(j)]+map[blist.get(j)][blist.get(i)];
			}
		}
		return Math.abs(asum-bsum);
	}

	private static void combi(int cnt, int start) {
		if (cnt == n / 2) {
			// System.out.println(Arrays.toString(visited));
			int sum = cal();
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;// 재료 선택
			combi(cnt + 1, i + 1);
			visited[i] = false;// 재료 비선택
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
