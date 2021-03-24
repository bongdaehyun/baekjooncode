package a0324_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_bj_2636_치즈 {
	static int [][]map;
	static int n,m;
	static boolean [][]change;
	public static void main(String[] args)throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		int totalcheeze=0;
		change=new boolean[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int time=0;
		
		while(true) {
			bfs(0,0);
//			for(int []m:map)System.out.println(Arrays.toString(m));
//			System.out.println();
			int countcheeze=0;//사라지는 치즈 수
			
			//바깥 공기를 만나는 치즈
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==1&&check(i,j)) {
						countcheeze++;
						map[i][j]=0;
					}
				}
			}
			if(countcheeze!=0)
				totalcheeze=countcheeze; //사라지는 치즈 저장
			else
				break;
			time++;
		}
		System.out.println(time);
		System.out.println(totalcheeze);
		in.close();
	}
	static boolean check(int x,int y) {
		for(int d=0;d<4;d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			
			if(map[nx][ny]==2) {
				change[x][y]=true;
				return true;
			}
		}
		return false;
	}
	static int dx[]= {0,1,-1,0};
	static int dy[]= {1,0,0,-1};
	//바깥 쪽 돌면서 공기를 2로 만든다.
	static void bfs(int x,int y) {
		ArrayDeque<int []>q=new ArrayDeque<>();
		boolean visited[][]=new boolean[n][m];
		q.add(new int[] {x,y});
		visited[x][y]=true;
		map[x][y]=2;
		
		while(!q.isEmpty()) {
			int cnt[]=q.poll();
			for(int k=0;k<4;k++) {
				int nx=cnt[0]+dx[k];
				int ny=cnt[1]+dy[k];
				
				if(0>nx||nx>=n||0>ny||ny>=m||visited[nx][ny]||map[nx][ny]==1)
					continue;
				map[nx][ny]=2;//바깥 공기 2로 표시
				q.add(new int[] {nx,ny});
				visited[nx][ny]=true;
			}
			
		}
		
	}
}
