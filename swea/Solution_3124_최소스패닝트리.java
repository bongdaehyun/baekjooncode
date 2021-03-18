package a0318_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static void make() {// 크기가 1인 단위 집합을 만든다
		for (int i = 0; i <= v; i++)
			parents[i] = i;
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		// return findSet(parents[a]); //path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후
	}

	static boolean union(int a, int b) {
		if (findSet(a) == findSet(b))
			return false;
		parents[findSet(b)] = findSet(a);
		return true;
	}

	static int v, e,ans;
	
	static int[] parents;
	//static Edge[] edgelist;

	static ArrayList<Edge>[]edgelist;
	static boolean []visited;
	static PriorityQueue<Edge>pq;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			//프림 + heap
			edgelist=new ArrayList[e];
			visited=new boolean[v+1];
			//min heap
			ans=0;
			
			for(int i=0;i<=v;i++) {
				edgelist[i]=new ArrayList<>();
			}
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgelist[from].add( new Edge(from, to, weight));
				edgelist[to].add( new Edge(to, from, weight));
			}
			prim_heap();
			System.out.println("#"+t+" "+ans);
			/* 크루스칼
			parents = new int[v+1];
			edgelist = new Edge[e];
			
			// 간선 정보
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgelist[i] = new Edge(from, to, weight);
			}
			
			Arrays.sort(edgelist);

			make();
			long result = 0;
			int count = 0;

			for (Edge edge : edgelist) {
				if (union(edge.from, edge.to)) {// 싸이클이 존재X
					result += edge.weight;
					if (++count == v - 1)
						break;
				}
			}
			System.out.println("#" + t + " " + result);
			 */
			
		}
		in.close();
	}
	static void prim_heap() {
		ArrayDeque<Integer>q=new ArrayDeque<>();
		pq=new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight-o2.weight;
			}
		});
		//start 지점 
		for(int i=1;i<=v;i++) {
			if(edgelist[i].size()>=1) {
				q.offer(edgelist[i].get(0).from);
				visited[edgelist[i].get(0).from]=true;
				break;
			}
		}
		while(!q.isEmpty()) {
			//현재노드
			int cnt=q.poll();
			for(int i=0;i<edgelist[cnt].size();i++) {
				if(!visited[edgelist[cnt].get(i).to])//방문 X
				{
					pq.add(edgelist[cnt].get(i));//현재 노드에 연결된 모든 간선을 우선순위 큐에 넣기
				}
			}
			
			//가장 작은 가중치의 값을 가진 노드로 이동
			while(!pq.isEmpty()) {
				Edge temp=pq.poll();
				if(!visited[temp.to]) {
					visited[temp.to]=true;
					ans+=temp.weight;
					q.add(temp.to);
					break;
				}
			}
		}
		
	}
}
