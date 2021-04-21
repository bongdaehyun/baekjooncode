package a0421_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_2458_키순서 {
	static int n,m;
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		ArrayList<Integer>big_list[]=new ArrayList[n+1];
		ArrayList<Integer>small_list[]=new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			big_list[i]=new ArrayList<>();
			small_list[i]=new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st=new  StringTokenizer(in.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			big_list[a].add(b);
			small_list[b].add(a);
		}
		int ans=0;
		for(int sx=1;sx<=n;sx++) {
			//자신보다 큰 키를 가진  사람 수
			int bp=bfs(sx,big_list);
			//자신보다 작은 키를 가진 수
			int sp=bfs(sx,small_list);
			
			//자신 뺀 사람의 수가 n-1이라면 순서를 암
			if(bp+sp==n-1)
				ans++;
		}
		System.out.println(ans);
		in.close();

	}
	static int bfs(int start,ArrayList<Integer>list[]) {
		int count=0;
		ArrayDeque<Integer>q=new ArrayDeque<>();
		boolean visited[]=new boolean[n+1];
		visited[start]=true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int cnt=q.poll();
			
			for(int next:list[cnt]) {
				if(!visited[next]) {
					count++;
					q.add(next);
					visited[next]=true;
				}
			}
		}
		
		return count;
	}
}
