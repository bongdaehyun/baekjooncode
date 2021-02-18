package a0218_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d5_1247_최적경로 {
	static int ans = 0;
	private static ArrayList<int[]> customer;
	static int[] pick;
	static boolean[] issel;
	static int sx, sy, ex, ey, n;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1247.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(in.readLine());
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE; //초기화
			customer = new ArrayList<>();//초기화
			n = stoi(in.readLine());//고객의 수
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			sx = stoi(st.nextToken());//회사위치
			sy = stoi(st.nextToken());
			ex = stoi(st.nextToken());//집위치
			ey = stoi(st.nextToken());
			pick = new int[n];//고객뽑을 배열
			issel = new boolean[n];//중복관리  X
			for (int i = 0; i < n; i++) {
				customer.add(new int[] { stoi(st.nextToken()), stoi(st.nextToken()) });
			}

			cal(0);
			System.out.println("#" + t + " " + ans);
		}

		in.close();
	}

	private static void cal(int cnt) {
		if (cnt == n) {
			ans=Math.min(set(pick),ans);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(issel[i])continue;
			pick[cnt] = i;
			issel[i]=true;
			cal(cnt + 1);
			issel[i]=false;
		}
	}

	private static int set(int[] pick) {
		int sum = 0;
		sum += Math.abs(sx - customer.get(pick[0])[0]) + Math.abs(sy - customer.get(pick[0])[1]); //집과 첫번째 고객

		for (int p = 0; p < n-1; p++) {
			sum += Math.abs(customer.get(pick[p])[0]-customer.get(pick[p+1])[0]) + Math.abs(customer.get(pick[p])[1] - customer.get(pick[p+1])[1]);
		}
		sum += Math.abs(ex- customer.get(pick[n-1])[0]) + Math.abs(ey-customer.get(pick[n-1])[1]);
		return sum;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
