package a0205_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d3_3499_퍼펙트셔플_구미_4_봉대현 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_3499.txt"));
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(in.readLine());
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(in.readLine());
			String s[]=in.readLine().split(" ");
			Queue <String>ql=new LinkedList<>();
			Queue <String>qr=new LinkedList<>();
			int mid=n%2==0?n/2: n/2+1;
			for(int i=0;i<n;i++) {
				if(i<mid) {
					ql.offer(s[i]);
				}
				else
					qr.offer(s[i]);
			}
			String []res=new String[n];
			int cnt=0;
			while(!ql.isEmpty()) {
				res[cnt++]=ql.poll();
				if(!qr.isEmpty())
					res[cnt++]=qr.poll();
			}
			System.out.print("#"+t+" ");
			for(String r:res)System.out.print(r+" ");
			System.out.println();
		}
		
		
		in.close();
	}

}
