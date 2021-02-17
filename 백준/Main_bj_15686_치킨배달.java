package a0217_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_15686_치킨배달 {
	static int[][] map;
	private static int c;
	private static int n;
	private static int res;
	static ArrayList<int[]> ch;
	static int[] pick;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = stoi(st.nextToken());
		c = stoi(st.nextToken());
		map = new int[n][n];
		ch = new ArrayList<>();
		pick = new int[c];
		res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			String s[] = in.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				map[i][j] = stoi(s[j]);
				if (map[i][j] == 2)
					ch.add(new int[] { i, j });
			}
		}
		
		combi(0, 0);
		System.out.println(res);
		in.close();
	}

	static void combi(int cnt, int start) {
		if (cnt == c) {
			bfs(pick);
			return;
		}
		for (int i = start; i < ch.size(); i++) {
			pick[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	static void bfs(int[] pick) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {// 집에서 치킨집과의 최소거리구하기
					int min=Integer.MAX_VALUE;
					for (int p : pick) { // 치킨집
						int x = ch.get(p)[0];
						int y = ch.get(p)[1];
						min=Math.min(getd(x,i,y,j), min);
						if(min==1)
							break;
					}
					sum+=min;
				}
			}
		}
		res = Math.min(sum, res);
	}

	static int getd(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
