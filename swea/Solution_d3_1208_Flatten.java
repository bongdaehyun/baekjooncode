package a0202_algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d3_1208_Flatten_구미_4_봉대현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1208.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int res = 0;
			// 덤프 횟수
			int dump =sc.nextInt();
			int[] boxs = new int[100];
			for (int i = 0; i < boxs.length; i++) {
				boxs[i] = sc.nextInt();
			}
			// 체크
			 //for(int b:boxs) System.out.print(b+" ");
			int Max_idx = 0;
			int Min_idx = 0;
	
			while (dump!=0) {
				// 최대 최소 찾기
				for (int i = 0; i < boxs.length; i++) {
					if (boxs[i] > boxs[Max_idx]) {
						Max_idx = i;
					}
					if(boxs[i]<boxs[Min_idx]) {
						Min_idx=i;
					}
				}
				boxs[Max_idx]-=1;
				boxs[Min_idx]+=1;
				dump--;
				//평탄화 완료
				if (boxs[Max_idx]-boxs[Min_idx]<=1)
					break;
			}//while end
			for (int i = 0; i < boxs.length; i++) {
				if (boxs[i] > boxs[Max_idx]) {
					Max_idx = i;
				}
				if(boxs[i]<boxs[Min_idx]) {
					Min_idx=i;
				}
			}
			res = boxs[Max_idx] - boxs[Min_idx];
			System.out.println("#" + t + " " + res);
			
		} // for end
		sc.close();
	}// main end

}// class end
