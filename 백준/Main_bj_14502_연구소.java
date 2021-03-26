package a0326_algo;

import java.util.*;
import java.io.*;

public class Main_bj_14502_연구소 {
	static int [][]map;
	static boolean visited[][];
	static int n,m,ans;
	static ArrayList<int []>virus;
	static boolean issel[][];
	static int[][]walls;
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		virus=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2)
					virus.add(new int[] {i,j});
			}
		}
		
		//굳이 필요없는 메모리..
		issel=new boolean[n][m];
		walls=new int[3][2];//벽 3개
		
		//벽을 세우면서 bfs로 안전영역 크기 구하기
		setwall(0,0);
		System.out.println(ans);
		in.close();

	}
	
	static void setwall(int cnt,int start) {
		if(cnt==3) {
			
			//이전 영역 저장
			int [][]copy=new int[n][m];
			for(int a=0;a<n;a++)
				copy[a]=map[a].clone();
			//벽생성
//			for(int i=0;i<walls.length;i++)
//				map[walls[i][0]][walls[i][1]]=1;
			
			bfs();
			int result=getSafeArea();
			ans=Math.max(ans,result);
			//원래의 영역으로 다시 바꿈
			for(int a=0;a<n;a++)
				map[a]=copy[a].clone();
			return;
		}
		for(int i=start;i<n;i++) {
			for(int j=0;j<m;j++) {
				//if(issel[i][j])continue;//벽으로 선택한경우
				if(map[i][j]!=0)continue; //빈칸이 아닌경우
				//walls[cnt][0]=i;
				//walls[cnt][1]=j;
				//issel[i][j]=true;
				map[i][j]=1;
				setwall(cnt+1,i);
				map[i][j]=0;
				//issel[i][j]=false;
			}
		}
	}
	static int dx[]= {0,1,-1,0};
	static int dy[]= {1,0,0,-1};
	
	static void bfs() {
		ArrayDeque<int []>q=new ArrayDeque<>();
		visited=new boolean[n][m];
		
		for(int i=0;i<virus.size();i++)
			q.add(virus.get(i));
		
		while(!q.isEmpty()) {
			int cnt[]=q.poll();
			if(visited[cnt[0]][cnt[1]])continue;
			visited[cnt[0]][cnt[1]]=true;
			
			for(int d=0;d<4;d++) {
				int nx=cnt[0]+dx[d];
				int ny=cnt[1]+dy[d];
				
				if(0<=nx&&0<=ny&&nx<n&&ny<m) {
					if(!visited[nx][ny]&&map[nx][ny]==0) {
						map[nx][ny]=2;
						q.add(new int[] {nx,ny});
					}
				}
			}
			
		}
	}
	static int getSafeArea() {
		int area=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0)
					area++;
			}
		}
		return area;
	}
}
