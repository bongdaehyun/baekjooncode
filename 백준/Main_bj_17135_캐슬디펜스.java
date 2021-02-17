package a0217_algo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

//성 칸 마다 1명의 궁수 , 거리 D이하 적중 가장 가까운 적, 가장 왼쪽 적, 같은 적이 
//여러명한테 당할 수 있다. 적이 없어지면 게임 set 
//23퍼 틀림 -> 적 중복 공격가능 문제 -> 우선순위때문에 제대로안됨
public class Main_bj_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	private static int[][] map;
	static int[] pick;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		pick = new int[3]; // 궁수 뽑은 위치
		map = new int[N][M]; // 입력받은 배열
		for (int i = 0; i < N; i++) {
			String s[] = in.readLine().split(" ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(s[j]);
		}
//		for(int []m:map)
//			System.out.println(Arrays.toString(m));
		combi(0, 0); // 궁수 배치
		System.out.println(res);
	}

	static void combi(int cnt, int start) {
		if (cnt == 3) { // 궁수 3명 배치하면 적을 죽일 수 있는 최대 수 구하기
			killenemy();
			return;
		}
		for (int i = start; i < M; i++) {
			pick[cnt] = i;
			combi(cnt + 1, i + 1);
		}
	}

	// 모든 궁수는 동시에 공격 처리 , 같은 적을 여러 궁수가 공격 가능
	static void killenemy() {
		// 성과 가까운 곳부터
		int[][] copy = new int[N][M];
		// copy=map이러면 제대로 복사가안됨
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copy[i][j] = map[i][j];

		int count = 0;
		int r1 = N;// 궁수 행 위치
		while (r1 != 0) {// 궁수가 위로 올라가는 형식
			ArrayDeque<int[]> enemy = new ArrayDeque<>();
			for (int k = 0; k < 3; k++) { // 3명의 궁수으로 죽이는 경우 탐색
				int c1 = pick[k]; // 궁수 열 위치
				int mind = D;
				int x = Integer.MAX_VALUE;
				int y = Integer.MAX_VALUE;
				for (int i = r1 - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (copy[i][j] == 1 && getdistance(r1, i, c1, j) <= D) { // 범위 에있는 것들 모두
							if (mind == getdistance(r1, i, c1, j)) // 가장 왼쪽
							{
								mind = getdistance(r1, i, c1, j);
								if (y > j) {
									x = i;
									y = j;
								}
							} else if (mind > getdistance(r1, i, c1, j)) { //가장 가까운
								mind = getdistance(r1, i, c1, j);
								x = i;
								y = j;
							}
						}
					}
				}
				if (x != Integer.MAX_VALUE && y != Integer.MAX_VALUE)
					enemy.add(new int[] { x, y });
			}
			// 적을 죽인다.
			while (!enemy.isEmpty()) {
				int temp[] = enemy.pollFirst();
				if (copy[temp[0]][temp[1]] == 1) {
					copy[temp[0]][temp[1]] = 0;
					count++;
				}
			}
			r1--;
		}
		res = Math.max(count, res);
	}

	static int getdistance(int r1, int r2, int c1, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
