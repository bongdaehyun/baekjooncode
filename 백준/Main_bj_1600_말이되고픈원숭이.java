package a0324_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//메모리초과
public class Main_bj_1600_말이되고픈원숭이 {
	static int k, w, h;
	static int[][] map;
	static int[] dx = { 0, 1, -1, 0 };
	static int[] dy = { 1, 0, 0, -1 };
	static int[] hx= {1,2,2,1,-1,-2,-2,-1};
	static int[] hy= {2,1,-1,-2,-2,-1,1,2};
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		k=Integer.parseInt(in.readLine());//말과 같이 최소 이동 수
		StringTokenizer st=new StringTokenizer(in.readLine());
		w=Integer.parseInt(st.nextToken());
		h=Integer.parseInt(st.nextToken());
		map=new int[h][w];
		
		for(int i=0;i<h;i++) {
			st=new StringTokenizer(in.readLine());
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//for(int m[]:map)System.out.println(Arrays.toString(m));
		//bfs
		boolean visited[][][]=new boolean[h][w][31];
		ArrayDeque<int []>q=new ArrayDeque<>();
		q.add(new int[] {0,0,0,k});
		visited[0][0][0]=true;
		
		while(!q.isEmpty()) {
			int []cnt=q.poll();
			if(cnt[0]==w-1&&cnt[1]==h-1) {
				System.out.println(cnt[2]);
				return;
			}
			if(cnt[0]>=w || cnt[1]>=h ||cnt[0]<0||cnt[1]<0)continue;
			if(map[cnt[1]][cnt[0]]==1 )continue;
			if(visited[cnt[1]][cnt[0]][cnt[3]])continue;
			visited[cnt[1]][cnt[0]][cnt[3]]=true;
			
			for(int d=0;d<4;d++) {
				int nx=cnt[0]+dx[d];
				int ny=cnt[1]+dy[d];
		
				q.add(new int[] {nx,ny,cnt[2]+1,cnt[3]});
				
			}
			if(cnt[3]==0)continue;
			//말처럼 이동가능
			for(int d=0;d<8;d++) {
				int nx=cnt[0]+hx[d];
				int ny=cnt[1]+hy[d];

				q.add(new int[] {nx,ny,cnt[2]+1,cnt[3]-1});
				
			}
		}
		System.out.println(-1);
		in.close();
		
	}
}
