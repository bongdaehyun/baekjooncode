package algo;
import java.util.*;

public class Main_bj_2846_오르막길 {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []list=new int[n];
		for(int i=0;i<n;i++)
			list[i]=sc.nextInt();
		
		int result=0;
		int start=list[0];
		for(int i=0;i<n-1;i++) {
			//오르막길 판단
			if(list[i]<list[i+1]) {
				if(result<list[i+1]-start)
					result=list[i+1]-start;
			}else {
				start=list[i+1];
			}
		}
		System.out.println(result);
	}

}
