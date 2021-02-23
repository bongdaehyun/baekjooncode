import java.util.Scanner;

public class Main_bj_2477_참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();// 참외 수
		int w = 0, h = 0;// 가장 가로 세로
		int w_idx = 0, h_idx = 0;// 가장 가로 세로 인덱스
		int s[][] = new int[6][2];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		// for(int p[]:s)System.out.println(Arrays.toString(p));
		for (int i = 0; i < 6; i++) {
			if (s[i][0] == 1 || s[i][0] == 2) {
				if (w < s[i][1]) {
					w = s[i][1];
					w_idx = i;
				}
			} else {
				if (h < s[i][1]) {
					h = s[i][1];
					h_idx = i;
				}
			}
		}
		// System.out.println(w+" "+h);
		int subw = Math.abs(s[(w_idx +5) % 6][1] - s[(w_idx + 1) % 6][1]);
		int subh = Math.abs(s[(h_idx +5) % 6][1] - s[(h_idx + 1) % 6][1]);
		System.out.println(((w*h)-(subw*subh))*k);
	}

}
