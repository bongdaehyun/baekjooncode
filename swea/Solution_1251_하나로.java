package a0324_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			double result=0;
			int n=Integer.parseInt(in.readLine());
			int []xlist=new int[n];
			int []ylist=new int[n];
			
			ArrayList<Node> []Nodelist=new ArrayList[n];
			for(int i=0;i<n;i++)
				Nodelist[i]=new ArrayList<>();
			
			StringTokenizer st=new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++) {
				xlist[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(in.readLine());
			for(int i=0;i<n;i++) {
				ylist[i]=Integer.parseInt(st.nextToken());
			}
			double tax=Double.parseDouble(in.readLine());
			
			//프림 +우선순위큐
			for(int i=0;i<n;i++) {
				for(int  j=i+1;j<n;j++) {
					double d=Math.pow(xlist[i]-xlist[j], 2)+Math.pow(ylist[i]-ylist[j], 2);
					//System.out.println(i+" "+j+" "+d);
					Nodelist[i].add(new Node(j,d));//각 정점마다의 거리 저장
					Nodelist[j].add(new Node(i,d));//각 정점마다의 거리 저장
				}
			}

			boolean []visited=new boolean[n];
			PriorityQueue<Node>pq=new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return Double.compare(o1.w, o2.w);
				}
			});
			pq.add(new Node(0,0));
			int cnt=0;
			while(!pq.isEmpty()) {
				Node node=pq.poll();
				if(visited[node.to])continue;
				visited[node.to]=true;
				result+=node.w;
				for(Node next:Nodelist[node.to]) {
					if(!visited[next.to]) {
						pq.add(next);
					}
				}
				if(++cnt==n)break;
			}
			
			System.out.println("#"+t+" "+Math.round(result*tax));
		}
		in.close();

	}
	static class Node {
		int to;
		double w;
		public Node(int to,double w) {
			super();
			this.to= to;	
			this.w=w;
		}
		
	}
}
