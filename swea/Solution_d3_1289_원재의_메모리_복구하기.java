package a0201_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d3_1289_원재의_메모리_복구하기_구미_4_봉대현 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1289.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int count = 1;
			int idx = 0;
			boolean check = false;
			String f = sc.next();
			char ca[] = new char[f.length()];
			for (int i = 0; i < f.length(); i++) {
				ca[i] = f.charAt(i);
				if (check==false && ca[i]=='1') {
					idx = i;
					check = true;
				}
			}
			for (int i = idx; i < ca.length - 1; i++) {
				if (ca[i] == ca[i + 1])
					continue;
				count++;
			}
			System.out.println("#" + tc + " " + count);
		}

		sc.close();
	}
}
