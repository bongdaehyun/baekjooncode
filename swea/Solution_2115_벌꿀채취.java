package a0422_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int n,m,c,ans,map[][];
	static boolean visited[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			//맵 크기
			n=Integer.parseInt(st.nextToken());
			//가로 연속 꿀 채취 수
			m=Integer.parseInt(st.nextToken());
			//최대 꿀 용량
			c=Integer.parseInt(st.nextToken());
			
			map=new int[n][n];
			visited=new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			ans=0;
			ArrayList<int []>ggul=new ArrayList<>();
			dopick(0,ggul);
			System.out.println("#"+t+" "+ans);
		}//for end
		
		
		in.close();
	}
	static int []pick;
	static int s;
	static void dopick(int cnt,ArrayList<int []>ggul) {
		//일꾼 2명
		if(cnt==2) {
//			for(boolean b[]:visited)
//				System.out.println(Arrays.toString(b));
//			System.out.println();
			//일꾼들이 뽑은 벌꿀
//			for(int i=0;i<2;i++) {
//				System.out.println(Arrays.toString(ggul.get(i)));
//			}
//			System.out.println();
			//벌꿀들의 합 구하기
			int total=0;
			for(int i=0;i<2;i++) {
				int sum=0;
				s=0;
				int cur[]=ggul.get(i);
				//System.out.println(Arrays.toString(cur));
				//용량이 안넘침
				if(isSum(cur)) {
					for(int j=0;j<cur.length;j++) {
						sum+=cur[j]*cur[j];
					}
				}else {//용량이 넘침
					//1~m-1까지  선택하여 최대 벌꿀의 합을 구함
					for(int p=1;p<m;p++) {
						pick=new int[p];
						System.out.println("p"+p);
						dfs(0,p,cur,0);
					}
					sum=s;
				}
				total+=sum;
			}
			ans=Math.max(total, ans);
			return;
		}
		boolean copy[][]=new boolean[n][n];
		for(int i=0;i<n;i++)
			copy[i]=visited[i].clone();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isavail(i, j)) {
					int temp[]=new int[m];
					//선택한 벌꿀들
					int idx=0;
					for(int k=j;k<j+m;k++) {
						visited[i][k]=true;
						temp[idx++]=map[i][k];
					}
					ggul.add(temp);
					dopick(cnt+1,ggul);
					ggul.remove(cnt);
					//원상복구
					for(int a=0;a<n;a++)
						visited[i]=copy[i].clone();
				}
					
			}
		}
	}
	static boolean isavail(int x,int y) {
		for(int i=y;i<y+m;i++) {
			if(i>=n)return false;
			if(visited[x][i])return false;
		}
		return true;
	}
	static boolean isSum(int cur[]) {
		int sum=0;
		for(int i=0;i<cur.length;i++) {
			sum+=cur[i];
			if(sum>c)
				return false;
		}
		return true;
	}
	
	static void dfs(int cnt,int end,int cur[],int start) {
		if(cnt==end) {
			//System.out.println(Arrays.toString(pick));
			int sum=0;
			for(int o=0;o<end;o++)
			{
				sum+=cur[pick[o]];
				if(sum>c)return;
			}
			sum=0;
			for(int o=0;o<end;o++)
			{
				sum+=cur[pick[o]]*cur[pick[o]];
			}
			s=Math.max(s, sum);
			//System.out.println("s "+s);
			return;
		}
		for(int i=start;i<cur.length;i++) {
			pick[cnt]=i;
			dfs(cnt+1,end,cur,i+1);
		}
	}
}
