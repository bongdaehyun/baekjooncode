package com.ssafy.algo;

import java.util.Scanner;

public class Main_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] switchs = new int[n + 1];// 1번부터 사용
		for (int i = 1; i < switchs.length; i++) {
			switchs[i] = sc.nextInt();
		}

		// 학생수
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 남 숫자의 배수
			if (x == 1) {
				int k = 1;
				int real_y=y;
				while (true) {
					if (y >= switchs.length)
						break;
					switchs[y] = (switchs[y] == 0) ? 1 : 0;
					y = real_y * (++k);
				}
			} else {// 여 좌우대칭확인
				// 양끝이면 대칭 x 좌우 인접 대칭 x
				if ((y == 1 || y == switchs.length - 1) || switchs[y-1] !=switchs[y+1]) {
					switchs[y] = (switchs[y] == 0) ? 1 : 0;
				}
				else {
					int left=y-1;
					int right=y+1;
					switchs[y] = (switchs[y] == 0) ? 1 : 0;
					while(left>0 && right<=switchs.length - 1) {
						if(switchs[left]==switchs[right]) {
							switchs[left]=switchs[left]==0? 1 : 0;
							switchs[right]=switchs[right]==0? 1 : 0;
							--left;
							++right;
						}
						else break;
					}
					
				}
			} // if end
		} // student for end

		for (int i = 1; i < switchs.length; i++) {
			System.out.print(switchs[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
		sc.close();
	}
}
