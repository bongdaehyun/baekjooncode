package a0415_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	
	static int [][]map;
	//상하좌우
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int[][] dir = { {}, {0,1,2,3}, {0,1}, {2,3}, {0,3}, {1,3}, {1,2}, {0,2}};
	static int n,m,r,c,l,ans;
	static ArrayDeque<int []>q;
	static boolean visited[][];
	
	public static void main(String[] args)throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			//지도크기
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			//맨홀 위치
			r=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			//소요 시간
			l=Integer.parseInt(st.nextToken());
			map=new int[n][m];
			//지도 입력
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<m;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//logic
			q=new ArrayDeque<>();
			visited=new boolean[n][m];
			q.add(new int [] {r,c});
			visited[r][c]=true;
			
			int time=1;
			ans=1;
			
			while(!q.isEmpty()) {
				if(time++ == l)
					break;
				int qsize=q.size();
				//터널끼리 같이 이동할수있기를
				while(qsize -->0) {
					int cnt[]=q.poll();
					bfs(cnt[0],cnt[1],map[cnt[0]][cnt[1]]);
				}
			}//end queue
			
			System.out.println("#"+t+" "+ans);
		}

		in.close();
	}
	
	static void bfs(int x,int y,int d) {
		for(int k:dir[d]) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			
			if(0<=nx&&0<=ny&&nx<n&&ny<m&&!visited[nx][ny]) {
				if(map[nx][ny]>=1&&isconnect(nx, ny, k))
				{
					visited[nx][ny]=true;
					ans++;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	//파이프랑 연결되는지 
	static boolean isconnect(int a,int b,int fd) {
		int direction=map[a][b];
		
		int wd=0; //꽂으려는 방향
		if(fd==0) //이동 방향
			wd=1;
		else if(fd==1)
			wd=0;
		else if(fd==2)
			wd=3;
		else if(fd==3)
			wd=2;
		//꽂히는 방향으로 현재지도에 되는지
		for(int i:dir[direction]) {
			if(wd==i)
				return true;
		}
		return false;
	}
}
