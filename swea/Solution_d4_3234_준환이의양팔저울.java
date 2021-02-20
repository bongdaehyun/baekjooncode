package a0219_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트레킹 문제 -모든 순열에서 가지치기를 해서 경우의 수를 줄이기
//왼쪽 무게 총합이 더 커야된다. 오른쪽 무게 총합보다. --가지치기
//입력 : 테케, 무게추의 개수, n개의 무게 추의 무게

public class Solution_d4_3234_준환이의양팔저울 {
	static int n, ans;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_3234.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());// 테스트 케이스
		
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(in.readLine());// 무게추의 개수
			ans=0;
			boolean[] visited = new boolean[n];
			int[] weight = new int[n];// 무게 추 무게 배열
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {// 무게추 무게 입력
				weight[i] = Integer.parseInt(st.nextToken());
			}
			// System.out.println(Arrays.toString(weight));

			per(0, 0, 0, visited, weight);

			System.out.println("#" + t + " " + ans);
		}

		in.close();
	}

	private static void per(int cnt, int left, int right, boolean[] visited, int[] weight) {
		if (cnt == n) {
			ans++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			per(cnt + 1, left + weight[i], right, visited, weight);
			if (right + weight[i] <= left)
				per(cnt + 1, left, right + weight[i], visited, weight);
			visited[i] = false;
		}

	}

}
