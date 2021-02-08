import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_6603_로또 {
	static int []num;
	static int n;
	static int []res;
	
	static void per(int cnt,int start) {
		if(cnt==6) {
			for(int i=0;i<6;i++)
				System.out.print(res[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=start;i<=n;i++) {
			res[cnt]=num[i];
			per(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s[]=in.readLine().split(" ");
			n=Integer.parseInt(s[0]);
			res=new int[6];
			if(n==0)
				break;
			num=new int[n+1];
			for(int i=1;i<=n;i++)
				num[i]=Integer.parseInt(s[i]);
			//for(int n:num)System.out.println(n);
			per(0,1);
			System.out.println();
		}
	}
}
