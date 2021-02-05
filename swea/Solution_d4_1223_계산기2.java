package a0205_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution_d4_1223_계산기2_구미_4_봉대현 {
//왜변환해서 계산해?
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/input_1223.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(in.readLine());
			ArrayDeque<Character> stack = new ArrayDeque<>();
			ArrayDeque<Integer> stack1 = new ArrayDeque<>();
			char[] input = in.readLine().toCharArray();
			char[] res = new char[n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				// 숫자면 바로 후위식 표현
				if (input[i] >= '0' && input[i] <= '9') {
					res[cnt++] = input[i];
				}
				// 연산자면 top과 비교해 우선순위가 높으면 push
				// 우선 순위가 낮은 연산자를 만날때까지 pop() ->우선순위가 낮지않으면 push
				// 넣기전에 비교
				else if (input[i] == '+') {
					while (!stack.isEmpty()) {
						res[cnt++] = stack.pollLast();
					}
					stack.addLast(input[i]);
				} else if (input[i] == '*') {
					while (!stack.isEmpty()) {
						// 연산자 우선순위가 낮은 연산자를 만날때까지 pop()
						if (stack.peekLast() == '+')
							break;
						else
							res[cnt++] = stack.pollLast();

					}
					stack.addLast(input[i]);
				}

			}
			//남은 스택의 연산자 후위식에 포함
			while (!stack.isEmpty()) {
				res[cnt++] = stack.pollLast();
			}
			// 후위계산
			int sum=0;
			for (int k = 0; k < n; k++) {
				//숫자면 바로 스택에
				if(res[k]>='0' &&res[k]<='9') {
					stack1.addLast(res[k]-'0');
				}
				else {//연산자면 스택에서 숫자를 2개꺼내고 연산 수행 후 다시 스택으로 
					if(res[k]=='*') {
						int nn=stack1.pollLast()*stack1.pollLast();
						stack1.addLast(nn);
					}
					else {
						int nk=stack1.pollLast()+stack1.pollLast();
						stack1.addLast(nk);
					}
				}
			}
			System.out.println("#" + t + " "+stack1.pop());
		}
		in.close();
	}

}
