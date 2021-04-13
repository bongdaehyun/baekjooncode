package a0413_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_활주로 {
	static int n,x;
	static int [][]map;
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st=new StringTokenizer(in.readLine());
			n=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			map=new int[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int result=0;
			//가로 줄 검사
			for(int []load:map) {
				if(checkLoad(load))
					result++;
			}
			//세로 줄 검사
			for(int i=0;i<n;i++) {
				int []temp=new int[n];
				for(int j=0;j<n;j++) {
					temp[j]=map[j][i];
				}
				if(checkLoad(temp))
					result++;
			}
			
			System.out.println("#"+t+" "+result);
		}
		
		
		in.close();
	}
	static boolean checkLoad(int []load) {
		//경사로를 깔았는지 체크
		boolean loadcheck[]=new boolean[n];
		
		for(int i=0;i<n-1;i++) {
			if(load[i]==load[i+1])
				continue;
			if(Math.abs(load[i]-load[i+1])>1)
				return false;
			
			//오른쪽 검사
			if(load[i]>load[i+1]) {
				int temp=load[i+1];
				//경사로의 길이만큼 가면서 비교
				for(int j=i+1;j<i+1+x;j++) {
					if(0>j || j==n)return false; //맵밖으로 나간경우
					if(load[j]!=temp)return false;//길이가 다른 경우
					if(loadcheck[j])return false; //활주로 중복 x
					loadcheck[j]=true;
				}
			}
			//왼쪽 검사
			else {
				int temp=load[i];
				for(int j=i;j>i-x;j--) {
					if(0>j||j==n)return false;
					if(load[j]!=temp)return false;
					if(loadcheck[j])return false;
					loadcheck[j]=true;
				}
			}
		}
		
		return true;
	}
}
