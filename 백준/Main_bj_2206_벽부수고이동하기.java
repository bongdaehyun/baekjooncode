import java.util.*;
import java.io.*;
//11퍼 틀림
public class Main_bj_2206_벽부수고이동하기 {
	static int dx[]= {0,1,-1,0};
	static int dy[]= {1,0,0,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int map[][]=new int[n][m];
		
		for(int i=0;i<n;i++)
		{
			String s[]=in.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		//for(int []ma:map)System.out.println(Arrays.toString(ma));
		boolean visited[][][]=new boolean[n][m][2];
		ArrayDeque<int []>q=new ArrayDeque<>();
		q.add(new int[] {0,0,1,0});//x,y,거리,벽부수기 가능
		visited[0][0][0]=true;//x,y,벽부수기 가능 상태 체크
		
		while(!q.isEmpty()) {
			int cnt[]=q.poll();
			
			if(cnt[0]==n-1&&cnt[1]==m-1)
			{
				System.out.println(cnt[2]);
				return;
			}
			//System.out.println(cnt[0]+" "+cnt[1]);
			for(int k=0;k<4;k++) {
				int nx=cnt[0]+dx[k];
				int ny=cnt[1]+dy[k];
				
				if(0<=nx&&nx<n&&0<=ny&&ny<m) {
					if(map[nx][ny]==1) {//벽인 경우
						if(cnt[3]==0&&!visited[nx][ny][cnt[3]+1]) {//벽을 부순적이 없음
							visited[nx][ny][cnt[3]+1]=true;
							q.add(new int[] {nx,ny,cnt[2]+1,cnt[3]+1});
						}
					}else {//벽이 아닌 경우
						if(!visited[nx][ny][cnt[3]]) {
							visited[nx][ny][cnt[3]]=true;
							q.add(new int[] {nx,ny,cnt[2]+1,cnt[3]});
						}
					}
				}
			}

		}
		System.out.println(-1);
		in.close();
	}
}
