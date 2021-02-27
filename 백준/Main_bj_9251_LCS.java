import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_9251_LCS {

	public static void main(String[] args)throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		char []A=in.readLine().toCharArray();//A 입력
		char []B=in.readLine().toCharArray();//B 입력
		int [][]LCS=new int[1001][1001]; //최대길이 1000
		 //i==0 or j==0 1행 1열은 다 0으로 채우기  -> 대각선 과 위쪽 왼쪽 모두 계산하기 편하게
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				if(A[i-1]==B[j-1]) { //같은 문자면 대각선의 값 +1
					LCS[i][j]=LCS[i-1][j-1]+1;
				}
				else {//다른 문자면 왼쪽 or 위쪽 둘중에 큰값
					LCS[i][j]=Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		System.out.println(LCS[A.length][B.length]);
		
		
		
		in.close();

	}

}
