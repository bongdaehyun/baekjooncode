package a0413_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_2564_경비원 {
	static int n, m, shopn, total;
	static ArrayList<int[]> shops;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		shopn = Integer.parseInt(in.readLine());
		int[] user = new int[2];
		shops = new ArrayList<>();
		for (int i = 0; i < shopn; i++) {
			st = new StringTokenizer(in.readLine());
			shops.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		st = new StringTokenizer(in.readLine());
		// 1 북 2 남 3 서 4 동
		user[0] = Integer.parseInt(st.nextToken());
		// 남 북 : 왼쪽경계에서 부터 동,서 : 위쪽 에서 거리
		user[1] = Integer.parseInt(st.nextToken());
		int result = 0;
		// 길의 전체길이
		total = m * 2 + n * 2;

		if (user[0] == 1) {
			int left = 0;
			int right = 0;
			for (int i = 0; i < shopn; i++) {
				if (shops.get(i)[0] == 1) {
					left = Math.abs(user[1] - shops.get(i)[1]);
					right = total - left;
					
				} else if (shops.get(i)[0] == 2) {
					left = user[1] + m + shops.get(i)[1];
					right = total - left;
				} else if (shops.get(i)[0] == 3) {
					left = user[1] + shops.get(i)[1];
					right = total - left;
				} else {
					left = (n - user[1]) + shops.get(i)[1];
					right = total - left;
				}
				
				result += Math.min(left, right);
			}
		} else if (user[0] == 2) {
			int left = 0;
			int right = 0;
			for (int i = 0; i < shopn; i++) {
				if (shops.get(i)[0] == 1) {
					left = user[1] + m + shops.get(i)[1];
					right = total - left;
				} else if (shops.get(i)[0] == 2) {
					left = Math.abs(user[1] - shops.get(i)[1]);
					right = total - left;
				} else if (shops.get(i)[0] == 3) {
					left = user[1] + (m - shops.get(i)[1]);
					right = total - left;
				} else {
					left = (n - user[1]) + (m - shops.get(i)[1]);
					right = total - left;
				}
				result += Math.min(left, right);
			}
		} else if (user[0] == 3) {
			int left = 0;
			int right = 0;
			for (int i = 0; i < shopn; i++) {
				if (shops.get(i)[0] == 1) {
					left = user[1] + shops.get(i)[1];
					right = total - left;
				} else if (shops.get(i)[0] == 2) {
					left = (m-user[1]) + shops.get(i)[1];
					right = total - left;
				} else if (shops.get(i)[0] == 3) {
					left = Math.abs(user[1] - shops.get(i)[1]);
					right = total - left;
				} else {
					left = m+user[1]+ shops.get(i)[1];
					right = total - left;
				}
				
				result += Math.min(left, right);
			}
		} else {
			int left = 0;
			int right = 0;
			for (int i = 0; i < shopn; i++) {
				if (shops.get(i)[0] == 1) {
					left = user[1] + n-shops.get(i)[1];
					
					right = total - left;
				} else if (shops.get(i)[0] == 2) {
					left = m-user[1] + n-shops.get(i)[1];
					right = total - left;
				} else if (shops.get(i)[0] == 3) {
					left = n+user[1] + shops.get(i)[1];
					right = total - left;
				} else {
					left = Math.abs(user[1] - shops.get(i)[1]);
					right = total - left;
				}
				
				result += Math.min(left, right);
			}
		}
		System.out.println(result);
		in.close();

	}

	
}
