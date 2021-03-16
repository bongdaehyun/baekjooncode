package a0316_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_d4_contact {
	static boolean checked[][];
	static int ans;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken()); // 개수
			int startnode = Integer.parseInt(st.nextToken());// 시작노드
			ans = 0;
			checked = new boolean[101][101];
			// 인접 정점
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				checked[from][to] = true;
			}
			bfs(startnode);
			System.out.println("#" + t + " " + ans);
		}
		in.close();
	}

	static void bfs(int startnode) {
		// 가장 나중에 연락을 받는 애들 그룹 중에 가장 큰 번호
		boolean visit[] = new boolean[101];
		int gnumber[]=new int[101];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(startnode);
		visit[startnode] = true;
		int level=0;
		gnumber[startnode]=level;
		while (!q.isEmpty()) {
			level+=1;
			int size=q.size();
			for (int k = 0; k <size ; k++) { //다자 간통화
				int cnt = q.pollFirst();
				for (int i = 0; i < 101; i++) {
					if (!visit[i] && checked[cnt][i])// 인접 정점과 미방문 정점
					{
						q.add(i);
						visit[i] = true;
						gnumber[i]=level;
					}
				}
			}
		}
		// 마지막 그룹 중에서 max뽑기
		for(int i=0;i<101;i++) {
			if (gnumber[i]==level-1) {
				ans=Math.max(ans,i);
			}
		}
	}
}
