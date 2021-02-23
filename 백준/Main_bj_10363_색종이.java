import java.util.Scanner;

public class Main_bj_10363_색종이 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [][]map=new int[102][102];
		int sum[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int p=sc.nextInt();
			int q=sc.nextInt();
			for(int j=x;j<x+p;j++)
				for(int k=y;k<y+q;k++)
					map[j][k]=i;
		}
		//for(int []m:map)System.out.println(Arrays.toString(m));
		for(int i=0;i<102;i++) {
			for(int j=0;j<102;j++) {
				if(map[i][j]>0)
					sum[map[i][j]]+=1;
			}
		}
		for(int i=1;i<n+1;i++)
			System.out.println(sum[i]);
	}

}
