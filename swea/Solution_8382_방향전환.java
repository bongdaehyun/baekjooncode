package a0419_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {

	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int sx=Integer.parseInt(st.nextToken());
			int sy=Integer.parseInt(st.nextToken());
			int ex=Integer.parseInt(st.nextToken());
			int ey=Integer.parseInt(st.nextToken());
			System.out.println("#"+t+" "+bfs(sx,sy,ex,ey));
		}

		in.close();
	}
	static int bfs(int sx,int sy,int ex,int ey) {
		int result=0;
		ArrayDeque<int []>q=new ArrayDeque<>();
		//가로 이동 0
		q.add(new int[] {sx,sy,0,0});
		//세로 이동 1
		q.add(new int[] {sx,sy,1,0});
		
		while(!q.isEmpty()) {
			int cnt[]=q.poll();
			
			if(cnt[0]==ex&&cnt[1]==ey)
			{
				result=cnt[3];
				break;
			}
			
			if(cnt[2]==0) {
				if(cnt[1]>ey)
					q.add(new int[] {cnt[0],cnt[1]-1,cnt[2]+1,cnt[3]+1});
				else
					q.add(new int[] {cnt[0],cnt[1]+1,cnt[2]+1,cnt[3]+1});
			}else {
				if(cnt[0]>ex)
					q.add(new int[] {cnt[0]-1,cnt[1],cnt[2]-1,cnt[3]+1});
				else
					q.add(new int[] {cnt[0]+1,cnt[1],cnt[2]-1,cnt[3]+1});
			}
		}
		
		return result;
		
	}
}
