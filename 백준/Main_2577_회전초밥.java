package a0415_algo;

import java.util.*;
import java.io.*;
public class Main_2577_회전초밥 {
//16퍼 틀림
//투포인터에다가 윈도우 슬라이드 개념까지 ..
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(in.readLine());
	
		int n=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int []menu=new int[n];
		for(int i=0;i<n;i++) {
			menu[i]=Integer.parseInt(in.readLine());
		}
		int result=0,total=0;
		//먹었는지 안먹었는지 중복 체크여부
		int eat[]=new int[d+1];
		//처음에서부터 연속된 음식 섭취
		for(int i=0;i<k;i++) {
			if(eat[menu[i]]==0)total++;
			eat[menu[i]]++;
		}
		result=total;
		
		for(int i=1;i<n;i++) {
			if(result<=total) {
				if(eat[c]==0)
					result=total+1;
				else
					result=total;
			}
			//맨 왼쪽에있는 음식 빼기
			eat[menu[i-1]]--;
			if(eat[menu[i-1]]==0)total--;
			
			if(eat[menu[(i+k-1)%n]]==0)total++;
			eat[menu[(i+k-1)%n]]++;
		}
		System.out.println(result);
	}

}
