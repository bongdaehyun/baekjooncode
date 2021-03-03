package asamsung_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_bj_17281_야구 {
	// 이닝이 바뀌어도 타순 유지
	// 이닝이 시작될때에는 주자 유지 x
	// 1. 타순을 구하기 -> 1번은 4번 타자 고정->순열로 구해서 가지치기!
	static int ans, n;
	static boolean issel[];
	static int pick[];
	static int stage[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());// 이닝!
		issel = new boolean[10];
		pick = new int[9];
		stage = new int[n][9];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 9; j++) {
				stage[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		call(0);
		System.out.println(ans);
		in.close();
	}

	static void call(int cnt) {
		if (cnt == 9) {
			if (pick[3] != 1)
				return;
			// q 타순
			ArrayDeque<Integer> q = new ArrayDeque<>();
			for (int i = 0; i < 9; i++)
				q.add(pick[i]);
			int count = 0;
			boolean base[] = new boolean[4]; // 4이상이 되면 득점
			int score = 0;
			int out = 0;
			while (count < n) {
				int result = q.pollFirst();
				if (stage[count][result - 1] == 0) {
					out += 1;
					if (out == 3) {// 다음 이닝
						count++;
						//초기화 
						base= new boolean[4];
						out = 0;
					}
				} else {
					int s =stage[count][result - 1];
					if(s== 4) {//홈런
						for(int i=1;i<4;i++) {
							if(base[i])
								score+=1;
						}
						score+=1;
						base= new boolean[4];
					}else if(s==3) {//3루타
						for(int i=1;i<4;i++) {
							if(base[i]) { //모든사람 홈으로
								score+=1;
								base[i]=false;
							}
						}
						base[3]=true;
					}else if(s==2) {//2루타
						for(int i=3;i>=1;i--) {
							if(base[i]) {
								if(i>=2) {//2루 3루 홈으로
									score+=1;
									base[i]=false;
									continue;
								}
								//1루
								base[i]=false;
								//3루까지
								base[i+2]=true;
							}
						}
						base[2]=true;
					}else {//1루타
						for(int i=3;i>=1;i--) {
							if(base[i]) {
								if(i==3) {
									score+=1;
									base[i]=false;
									continue;
								}
								//1루,2루  다음 루까지
								base[i]=false;
								base[i+1]=true;
							}
						}
						base[1]=true;
					}
				}
				q.add(result);
			}
			ans = Math.max(ans, score);
			return;
		}
		for (int i = 1; i < 10; i++) {// 타순 정하기
			if (issel[i])
				continue;
			pick[cnt] = i;
			issel[i] = true;
			call(cnt + 1);
			issel[i] = false;
		}
	}
}
