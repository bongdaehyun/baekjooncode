package a0215_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_3040_백설공주와일곱난쟁이_구미_4_봉대현 {

	static int[] pick;
	private static int[] nums;
	static boolean issel[];
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[9];
		pick = new int[7];
		issel=new boolean[9];
		for (int i = 0; i < 9; i++)
			nums[i] = Integer.parseInt(in.readLine());
		dfs(0);
		
	}

	static void dfs(int cnt) {
		if(flag)
			return;
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++)
				sum += pick[i];
			if(sum==100)
			{
				for (int i = 0; i < 7; i++)
					System.out.println(pick[i]);
				flag=true;
				return;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(issel[i])continue;
			pick[cnt] = nums[i];
			issel[i]=true;
			dfs(cnt + 1);
			issel[i]=false;
		}
	}
}
