package a0210_algo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_d4_1233_사칙연산유효성검사_구미_4_봉대현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1233.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// 계산이 가능하면 1 안되면 0
		// 주어지는 트리는 완전 이진 트리
		// 0으로 나누는건 X

		// 1. 단말 노드는 숫자가 들어와야된다 ? 아니면 계산 X 아이디어 1
		for (int t = 1; t <= 10; t++) {
			int res = 1; // 결과 값
			int n = Integer.parseInt(in.readLine());// 노드 개수
			// 이진트리 배열
			// String []tree=new String[n+1];

			for (int i = 0; i < n; i++) {
				String s[] = in.readLine().split(" ");
				// tree[stoi(s[0])]=s[1];
				if (res==1 && s[1].charAt(0) == '*' || s[1].charAt(0) == '+' || s[1].charAt(0) == '-' || s[1].charAt(0) == '/') {
					if (s.length < 3) {
						res = 0;
					}
				}
			}

			System.out.println("#" + t + " " + res);
		}
		in.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);

	}

}
