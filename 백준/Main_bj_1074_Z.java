package a0216_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1074_Z {

	private static int r;
	private static int c;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = stoi(st.nextToken());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());

		int N = 1 << n;// 배열 크기
		int count=0;
		int x = 0, y = 0;
		while (N > 0) {
			N /= 2;
			
			// 1사분면
			if (r < x + N) {
				count += N * N * 1;
				y += N;
			}
			else if (r < x + N && c < y + N)// 2사분면
			{
				count += N * N * 0;
			}
			else if (c < y + N)// 3사분면
			{
				count += N * N * 2;
				x += N;
			} else {
				count += N * N * 3;
				x += N;
				y += N;
			}
			if (N == 1) {
				System.out.println(count);
				break;
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
