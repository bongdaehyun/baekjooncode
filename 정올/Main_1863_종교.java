package a0318_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1863_종교 {
	static int n;
	static int parents[];
	static void make() {
		for(int  i=1;i<=n;i++)
			parents[i]=i;
	}
	static int find(int p) {
		if(parents[p]==p)return p;
		return parents[p]=find(parents[p]);
	}
	static boolean union(int a,int b) {
		if(find(a)==find(b)) return false;
		parents[find(b)]=find(a);
		return true;
	}
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		parents=new int[n+1];
		make();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(in.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		//System.out.println(Arrays.toString(parents));
		//개수 세기
		int count=0;
		for(int i=1;i<=n;i++) {
			if(i==parents[i])
				count++;
		}
		
		System.out.println(count);
		in.close();
	}

}
