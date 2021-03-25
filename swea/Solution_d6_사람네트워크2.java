package a0325_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d6_사람네트워크2 {

	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			int n=Integer.parseInt(st.nextToken());
			int [][]dist=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dist[i][j]=Integer.parseInt(st.nextToken());
					if(i!=j&&dist[i][j]==0)
						dist[i][j]=999999;
				}
			}
			
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(dist[i][j]>dist[i][k]+dist[k][j])
							dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
			//for(int []d:dist)System.out.println(Arrays.toString(d));
			int min=99999;
			for(int i=0;i<n;i++) {
				int  temp=0;
				for(int j=0;j<n;j++) {
					temp+=dist[i][j];
				}
				min=Math.min(temp, min);
			}
			System.out.println("#"+t+" "+min);
		}
		
		in.close();

	}

}
