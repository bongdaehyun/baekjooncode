package a0318_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_서로소집합 {
	static int []p;
	static int n,m;
	static void make() {
		for(int i=1;i<=n;i++)
			p[i]=i;
	}
	static int find(int a) {
		if(p[a]==a)return a;
		
		return p[a]=find(p[a]);
	}
	static void union(int a,int b) {
		int aroot=find(a);
		int broot=find(b);
		
		if(aroot==broot)
			return;
		p[broot]=aroot;
		
	}

	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=null;
		int T=stoi(in.readLine());
		for(int t=1;t<=T;t++) {
			sb=new StringBuilder();
			String []s=in.readLine().split(" ");
			n=stoi(s[0]);
			m=stoi(s[1]);
			p=new int[n+1];
			
			make();
			for(int i=0;i<m;i++) {
				StringTokenizer st=new StringTokenizer(in.readLine());
				int oper=stoi(st.nextToken());
				int a=stoi(st.nextToken());
				int b=stoi(st.nextToken());
				
				if(oper==1) {
					int aroot=find(a);
					int broot=find(b);
					if(aroot==broot)
						sb.append(1);
					else
						sb.append(0);
					
				}else
					union(a, b);
				
				//System.out.println(Arrays.toString(p));
			}
			System.out.println("#"+t+" "+sb.toString());
		}
		in.close();
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
