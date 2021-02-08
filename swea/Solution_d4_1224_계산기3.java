import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution_d4_1224_계산기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(in.readLine());
			ArrayDeque<Character> stack = new ArrayDeque<>();
			ArrayDeque<Integer> stack1 = new ArrayDeque<>();
			char[] input = in.readLine().toCharArray();
			//Stringbuilder를 사용하면 더 편하게 할 수 있음.. 괄호를 생각안해도됨.
			StringBuilder sb=new StringBuilder();
			for (int i = 0; i < n; i++) {
				// 숫자면 바로 후위식 표현
				if (input[i] >= '0' && input[i] <= '9') {
					sb.append(input[i]);
				}
				// 연산자면 top과 비교해 우선순위가 높으면 push
				// 우선 순위가 낮은 연산자를 만날때까지 pop() ->우선순위가 낮지않으면 push
				// 넣기전에 비교
				else if(input[i]=='(') {
					stack.addLast(input[i]);
				}
				else if (input[i] == '+') {
					while (!stack.isEmpty()) {
						if(stack.peekLast()=='(')
							break;
						sb.append(stack.pollLast());
					}
					stack.addLast(input[i]);
				} else if (input[i] == '*') {
					while (!stack.isEmpty()) {
						// 연산자 우선순위가 낮은 연산자를 만날때까지 pop()
						if (stack.peekLast() == '+' ||stack.peekLast()=='(')
							break;
						else
							sb.append(stack.pollLast());
					}
					stack.addLast(input[i]);
				}
				else {// 닫힌 괄호가 올때 열린 괄호가 올때까지 다 빼기
					while(!stack.isEmpty()){
						if(stack.peekLast()=='(')
							break;
						else
							sb.append(stack.pollLast());
					}
					//여는 괄호는 버리기
					stack.pollLast();
				}
			}
			//남은 스택의 연산자 후위식에 포함
			while (!stack.isEmpty()) {
				sb.append(stack.pollLast());
			}
			String s=sb.toString();
			// 후위계산
			for (int k = 0; k <s.length(); k++) {
				//숫자면 바로 스택에
				if(s.charAt(k)>='0' &&s.charAt(k)<='9') {
					stack1.addLast(s.charAt(k)-'0');
				}
				else {//연산자면 스택에서 숫자를 2개꺼내고 연산 수행 후 다시 스택으로 
					if(s.charAt(k)=='*') {
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
