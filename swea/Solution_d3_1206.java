import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_d3_1206 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_1206.txt"));
		Scanner sc=new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int count=0;
			int N=sc.nextInt();
			int []buildings=new int[N];
			
			for(int i=0;i<N;i++)
				buildings[i]=sc.nextInt();
			for(int i=0;i<N;i++) {
				if(buildings[i]==0) continue;
				//맨왼쪽 건물은 우만 확인
				if(i==0) {
					if(buildings[i+1] <buildings[i] &&buildings[i+2]<buildings[i])
						count+=buildings[i]-Math.max(buildings[i+1], buildings[i+2]);
					
				}else if(i==N-1) {//맨 오른쪽 건물은 좌만 확인
					if(buildings[i-1] <buildings[i] &&buildings[i-2]<buildings[i])
						count+=buildings[i]-Math.max(buildings[i-1], buildings[i-2]);
				}
				else {
					if(i+1<N&&i+2<N&&0<=i-1&&0<=i-2) {
						if(buildings[i+1] <buildings[i] &&buildings[i+2]<buildings[i]&&buildings[i-1] <buildings[i] &&buildings[i-2]<buildings[i])
						{
							count+=buildings[i]-Math.max(Math.max(buildings[i+1], buildings[i+2]), Math.max(buildings[i-1], buildings[i-2])); 
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+count);
		}
		
		
		sc.close();
		
	}
}
