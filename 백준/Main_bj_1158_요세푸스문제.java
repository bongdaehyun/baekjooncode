package a0209_algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_bj_1158_요세푸스문제_구미_4_봉대현 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		//int [] res=new int[n];
		sb.append("<");
		Queue<Integer>q=new LinkedList<>();
		for(int i=1;i<=n;i++)
			q.add(i);
		int count=1;
		//int idx=0;
		while(!q.isEmpty()) {
			int cnt=q.poll();
			if((count++)==k) {
				sb.append(cnt).append(", ");
				//res[idx++]=cnt;
				count=1;
			}else
				q.add(cnt);

		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
//		System.out.print("<");
//		for(int i=0;i<n;i++)
//		{
//			if(i!=n-1)
//				System.out.print(res[i]+", ");
//			else
//				System.out.print(res[i]);
//		}
//		System.out.print(">");
		sc.close();
	}

}
