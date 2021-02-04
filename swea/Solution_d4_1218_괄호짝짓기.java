package a0204_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_d4_1218_괄호짝짓기_구미_4_봉대현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1218.txt"));
		//Scanner sc = new Scanner(System.in);
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>();
			//int N = sc.nextInt();
			int N = Integer.parseInt(in.readLine());
			//String s = sc.next();
			String s =in.readLine();
			int top = -1;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.push(c);
					top++;
				} else {
					// ) } ] 부터 들어오면 괄호짝안됨
					if (stack.isEmpty())
						break;
					else {
						if (c == ')'&&stack.get(top) == '(') {
								stack.pop();
								top--;
						} else if (c == '}'&&stack.get(top) == '{') {	
								stack.pop();
								top--;
						} else if (c == ']'&&stack.get(top) == '[') {
								stack.pop();
								top--;
						} else if (c == '>'&&stack.get(top) == '<') {
								stack.pop();
								top--;
						} else
							stack.push(c);
					}
				}
			}

			System.out.print("#" + t + " ");
			if (stack.isEmpty())
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

}
