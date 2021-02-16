package a0216_algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1828_냉장고_구미_4_봉대현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] ary = new int[n][2];
		for (int i = 0; i < n; i++) {
			ary[i][0] = sc.nextInt();
			ary[i][1] = sc.nextInt();
		}
		Arrays.sort(ary,new Comparator<int []>() { //최고 온도 오름차순

			@Override
			public int compare(int [] o1, int [] o2) {
				return o1[1]-o2[1];
			}
		});
		int []temp=ary[0];//초기값 0 로 시작
		int count=1;
		for(int i=1;i<n;i++) {
			if(temp[1] <ary[i][0]) {
				temp=ary[i];
				count++;
			}
			
		}
		System.out.println(count);
		sc.close();
	}

}
