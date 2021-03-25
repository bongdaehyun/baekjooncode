import java.util.*;
public class Main_bj_2565_전깃줄 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int LIS[]=new int[n];
		int [][]wire=new int[n][2];
		for(int i=0;i<n;i++) {
			wire[i][0]=sc.nextInt();
			wire[i][1]=sc.nextInt();
		}
		Arrays.sort(wire,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {				
				return o1[0]-o2[0];
			}
		});
		
		int count=0;
		for(int i=0;i<n;i++) {
			LIS[i]=1;
			for(int j=0;j<i;j++) {
				if(wire[j][1]<wire[i][1]&&LIS[i]<LIS[j]+1) {
					LIS[i]=LIS[j]+1;
				}
			}
			if(count<LIS[i])count=LIS[i];
		}
		System.out.println(n-count);
	}
	

}
