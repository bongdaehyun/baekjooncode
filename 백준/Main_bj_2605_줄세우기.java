package algo;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main_bj_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num[] = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = sc.nextInt();
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (num[i] == 0)
				q.addLast(i + 1);
			else {
				ArrayDeque<Integer> tmp = new ArrayDeque<>();
				for (int j = 0; j < num[i]; j++) {
					tmp.add(q.pollLast());
				}
				q.addLast(i+1);
				for(int j=0;j<num[i];j++)
					q.addLast(tmp.pollLast());
			}
		}
		while(!q.isEmpty())
			System.out.print(q.pollFirst()+" ");
		sc.close();
	}

}
