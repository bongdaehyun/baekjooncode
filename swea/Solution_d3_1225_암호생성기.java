package a0204_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d3_1225_암호생성기_구미_4_봉대현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_1225.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int T = Integer.parseInt(in.readLine());
			Queue<Integer> q = new LinkedList<>();
			String[] s = in.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				q.offer(Integer.parseInt(s[j]));
			}
			// 배열 확인
//			while(!q.isEmpty()) {
//				System.out.println(q.poll());
//			}
			// 한 사이클에 5까지 감소 사이클 종료시 다시 1로
			int cycle = 1;
			while (true) {
				// top이 0보다 작으면 종료 그리고 0으로 유지
				if (cycle == 6)
					cycle = 1;
				int cnt = q.poll();
				cnt -= cycle++;
				if (cnt <= 0) {
					q.offer(0);
					break;
				} else
					q.offer(cnt);
			}
			System.out.print("#" + T + " ");
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}

		in.close();
	}

}
