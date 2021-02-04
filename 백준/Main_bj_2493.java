package a0204_algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_bj_2493_탑_구미_4_봉대현 {
	//배열은 시간초과!! N^2 스택으로 ~해보자
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		String[] s = in.readLine().split(" ");
		//번호와 건물 값 저장하는 배열
		Stack<int []>tops=new Stack<>();
		int res []=new int [N];
		for (int i = 0; i < s.length; i++) {
			int cnt=Integer.parseInt(s[i]);
			//작은 값을 계속 제외하기 위한 반복문
			while(!tops.isEmpty()) {
				//탑이 들어오는 값보다 크면 바로 송신
				if(tops.peek()[1]>=cnt) {
					res[i]=tops.peek()[0];
					tops.push(new int [] {i+1,cnt});
					break;
				}
				//들어오는 값보다 탑이 더 작으면 제외
				tops.pop();
			}
			//맨앞에 있는 애들은 0로 송신 스택에 넣기
			if(tops.isEmpty()) {
				res[i]=0;
				tops.push(new int [] {i+1,cnt});
			}
		}
		for(int r:res)System.out.print(r+" ");
		in.close();
	}
}
