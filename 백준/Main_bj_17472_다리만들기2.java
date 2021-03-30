package a0326_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//4퍼 틀림-> 이유: 모든 섬들이 연결되어있다는 조건을 확인안함..
//프림에서 방문했던 곳들의 개수를 세어서 정점의 개수랑 맞다면 거리 아니면 -1로 해결

public class Main_bj_17472_다리만들기2 {

	static int n, m, ans;
	static int dx[] = { 0, 1, -1, 0 };
	static int dy[] = { 1, 0, 0, -1 };
	static int map[][];
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		// 섬들의 좌표 구하기
		int label = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j, label++);// 섬들 라벨링하기
				}
			}
		}
		
		//showmap();
		//인접리스트
		ArrayList<int[]> lands[] = new ArrayList[label];
		for (int i = 2; i < label; i++) {
			lands[i] = new ArrayList<>();
		}
		//섬들끼리의 거리를 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] >= 2) {
					// 4방향 dfs
					for (int d = 0; d < 4; d++) {
						int dist[] = getdistance(i, j, d);// 거리와 어디정점
						if (dist[0] < 2 || map[i][j]==dist[1])//거리가 2미만, 같은 섬으로 갔을 경우
							continue;
						//System.out.println(map[i][j] + " " + dist[1] + " " + dist[0]);
						// 인접 섬들 연결 및 거리
						//중복되는것이 많다??.. 나중에 set으로 처리해야될듯 시간초과나면..
						lands[map[i][j]].add(dist);
						//lands[dist[1]].add(new int[] { dist[0], map[i][j] });

					}
				}
			}
		}
		//prim으로 구하기
		PriorityQueue<int []>pq=new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		boolean visit[]=new boolean[label];
		pq.add(new int[] {0,2});
		int cnt=0;
		int ans=0;
		while(!pq.isEmpty()){
			int temp[]=pq.poll();
			if(visit[temp[1]])continue;
			visit[temp[1]]=true;
			ans+=temp[0];
			//System.out.println(temp[0]);
			for(int []node:lands[temp[1]]) {
				if(!visit[node[1]])
					pq.add(node);
			}
			if(++cnt==label-2)break;
		}
		//System.out.println(Arrays.toString(visit));
		int count=0;
		for(int i=2;i<label;i++) {
			if(visit[i])
				count++;
		}
		if(count!=label-2)
			System.out.println(-1);
		else
			System.out.println(ans);
		in.close();

	}

	static void showmap() {
		for (int ma[] : map)
			System.out.println(Arrays.toString(ma));
	}

	static int[] getdistance(int x, int y, int d) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		
		int dist=0;
		int label=0;
		boolean flag=false;
		while (!q.isEmpty()) {
			int cnt[]=q.poll();
					
			int nx = cnt[0] + dx[d];
			int ny = cnt[1] + dy[d];

			if (0 <= nx && 0 <= ny && nx < n && ny < m) {
				if (map[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.add(new int[] { nx, ny });
					dist++;
				}else {
					flag=true;
					label=map[nx][ny];
					break;
				}
			}
		}
		//다른 섬과 만났을 경우
		if(flag)
			return new int[] {dist,label};
		else
			return new int[] {-1,-1};
	}

	static void bfs(int x, int y, int label) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.add(new int[] { x, y });
		map[x][y] = label;
		while (!q.isEmpty()) {
			int cnt[] = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cnt[0] + dx[d];
				int ny = cnt[1] + dy[d];

				if (0 <= nx && 0 <= ny && nx < n && ny < m && !visited[nx][ny]) {
					if (map[nx][ny] == 1) {
						visited[nx][ny] = true;
						q.add(new int[] { nx, ny });
						map[nx][ny] = label;
					}
				}
			}
		}
	}
}
/*
10 10
0 0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 0 0 1 1
0 1 1 0 0 0 0 0 0 0
0 0 0 0 0 1 1 0 0 0
0 0 0 0 0 1 1 0 0 0
0 1 1 0 0 0 0 0 0 0
0 1 1 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 1 1 0
 */
