package a0322_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1681_해밀턴순환회로 {
	static int n, ans;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		visited = new boolean[n];
		ans=Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			String s[] = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		dfs(1, 0, 0);//1번에서 출발
		System.out.println(ans);
		in.close();
	}

	static void dfs(int cnt, int start, int sum) {
		if(sum>=ans) {//중간 비용이 더큰경우 
			return;
		}
		if (cnt == n) {
			if(map[start][0]!=0)//다시 회사로 돌아오는 길이 있다면.
				ans=Math.min(ans, sum+map[start][0]);
			return;
		}

		for (int i = 1; i < n; i++) {
			if (!visited[i] && map[start][i] != 0) {
				visited[i] = true;
				dfs(cnt + 1, i, sum+map[start][i]);
				visited[i] = false;
			}
			
		}
	}
}
