package a0412_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	// 상우하좌
	static int dx[] = { 0, -1, 0, 1, 0 };
	static int dy[] = { 0, 0, 1, 0, -1 };
	static ArrayList<int[]> aps;
	static int a;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			int[][] user = new int[2][m + 1];
			// 이동정보 입력
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= m; j++) {
					user[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			aps = new ArrayList<>();
			// bc의 정보
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				aps.add(new int[] { y, x, c, p });
			}
			int[] user1 = new int[] { 1, 1 };
			int[] user2 = new int[] { 10, 10 };

			int result = 0;
			// 초기위치도 체크

			// 이동 -> 지도 밖으로 이동 x
			for (int i = 0; i <= m; i++) {
				// 사용자 1
				user1[0] += dx[user[0][i]];
				user1[1] += dy[user[0][i]];

				// 사용자 2
				user2[0] += dx[user[1][i]];
				user2[1] += dy[user[1][i]];
				result+=getvalue(user1, user2);

			}
			System.out.println("#" + t + " " + result);
		}

		in.close();
	}
	static int getvalue(int u1[],int u2[]) {
		int max=0;
		int [][]amount=new int[2][a];
		//사용자 1
		for(int j=0;j<a;j++) {
			amount[0][j]=checkd(u1, j);
		}
		//사용자 2
		for(int j=0;j<a;j++) {
			amount[1][j]=checkd(u2, j);
		}
		
		//충전량의 합 중 최댓값
		for(int i=0;i<a;i++) {
			for(int j=0;j<a;j++) {
				int sum=amount[0][i]+amount[1][j];
				//같은 곳이고 충전량이 같은것
				if(i==j&&amount[0][i]==amount[1][j])
					sum/=2;
				max=Math.max(max,sum);
			}
		}
		
		return max;
	}
	static int checkd(int[] d, int i) {

		if (Math.abs(aps.get(i)[0] - d[0]) + Math.abs(aps.get(i)[1] - d[1]) <= aps.get(i)[2]) {
			return aps.get(i)[3];// 충전량
		}

		return 0;
	}
}
