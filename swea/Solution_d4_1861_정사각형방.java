package a0205_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution_d4_1861_정사각형방_구미_4_봉대현 {
static int []dx= {1,0,-1,0};
static int []dy= {0,1,0,-1};
static int [][]map;
//static boolean [][]visited;
static int Maxd;
static int roomnum;

	static void dfs(int x, int y,int n) {
		//visited=new boolean[n][n];
		ArrayDeque<int []>stack=new ArrayDeque<>();
		stack.push(new int[] {x,y});
		//visited[x][y]=true;
		//방개수 체크
		int distant=1;
		while(!stack.isEmpty()) {
			//탐색할 start 좌표
			int cnt[]=stack.pop();
			//4방향 탐색
			for(int k=0;k<4;k++) {
				int nx=dx[k]+cnt[0];
				int ny=dy[k]+cnt[1];
				if(0<=nx&&nx<n&&0<=ny&&ny<n) {
					if(map[nx][ny]==map[cnt[0]][cnt[1]]+1) {
						stack.push(new int[] {nx,ny});
						++distant;
						//visited[nx][ny]=true;
					}
				}
			}
		}
		//최대거리 저장
		if(distant>Maxd)
		{
			Maxd=distant;
			roomnum=map[x][y];

		}
		//최대거리 중 방번호가 작게
		if(distant==Maxd) {
			if(roomnum>map[x][y])
				roomnum=map[x][y];
		}
	}
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_1861.txt"));
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++) {
			roomnum=0;
			Maxd=0;
			int n=Integer.parseInt(in.readLine());
			map=new int[n][n];
			for(int i=0;i<n;i++) {
				String []s=in.readLine().split(" ");
				for(int j=0;j<n;j++)
					map[i][j]=Integer.parseInt(s[j]);
			}
			//for(int []m:map) System.out.println(Arrays.toString(m));
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					dfs(x,y,n);
				}
			}
			System.out.println("#"+t+" "+roomnum+" "+Maxd);
		}
		in.close();
	}

}
