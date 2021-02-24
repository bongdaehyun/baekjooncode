import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_d2_1940_가랏rc카 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input_1940.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			int sum=0;
			int 속도=0;
			for(int i=0;i<n;i++) {
				int x=sc.nextInt();
				
				if(x==1) {
					int y=sc.nextInt();
					속도+=y;
				}
				else if(x==2){
					int y=sc.nextInt();
					속도-=y;
					if(속도<0)
						속도=0;
				}
				sum+=속도;
			}
			System.out.println(sum);
			
		}
		
		sc.close();
	}

}
