package a0423_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_17143_낚시왕 {
	static int[][] map;
	static int r, c, m, ans;
	static ArrayList<shark> sharks;
	static ArrayList<Integer> dielist;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// 낚시왕이 오른쪽 한칸 이동
		// 낚시왕이 있는 열에 있는 중땅과 가까운 것 잡기
		// 상어 이동

		// 상어입력
		sharks = new ArrayList<>();
		dielist = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			sharks.add(new shark(x, y, s, d, z));
		}

		// 낚시왕 오른쪽으로 이동
		for (int i = 1; i <= c; i++) {
			//System.out.println("time : " + i);
			map = new int[r + 1][c + 1];
			createMap();
			// 낚시왕이 있는 열에 있는 상어 체크
			int idx = doCheckcol(i);
			if (idx != -1) {
//				System.out.println(sharks.get(idx));
//				System.out.println();
				// 포확한 상어 잡아가기
				ans += sharks.get(idx).z;
				sharks.remove(idx);
			}
			// 살아 남은 상어 이동
			for (int j = 0; j < sharks.size(); j++)
				move(j);
			// 죽은 상어들 삭제
			Collections.sort(dielist, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			
			for (int die : dielist) {
				//System.out.print(die);
				sharks.remove(die);
			}
			dielist.clear();
//			System.out.println("살아 있는 상어들------");
//			for (shark s : sharks)
//				System.out.println(s);

		}
		System.out.println(ans);
		in.close();

	}
	static void createMap() {
		for(int i=1;i<=r;i++) {
			for(int j=1;j<=c;j++)
				map[i][j]=-1;
		}
	}
	// 위 아래 오른 왼
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	static void move(int idx) {
		// 격자판의 경계를 넘는 경우에는 방향을 반대로 바꿔서
		// 속력을 유지한채로 이동한다.
		int x = sharks.get(idx).x;
		int y = sharks.get(idx).y;
		int d = sharks.get(idx).d;
		int s = sharks.get(idx).s;
		while (s-- > 0) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			// 맵안.
			if (1 <= nx && 1 <= ny && nx < r + 1 && ny < c + 1) {
				x = nx;
				y = ny;
			} else {// 경계를 벗어난 경우
					// 방향 반대로
				if (d == 1) {
					d = 2;
				} else if (d == 2) {
					d = 1;
				} else if (d == 3) {
					d = 4;
				} else if (d == 4) {
					d = 3;
				}
				// 움직임 한번 증가
				s++;
			}

		} // while end
		
		// 물고기 위치 수정
		sharks.get(idx).x = x;
		sharks.get(idx).y = y;
		sharks.get(idx).d = d;
		
		// 칸에 아무도 없다면
		if (map[x][y] == -1)
			map[x][y] = idx;
		else {
			// 원래 있던 물고기보다 크기가 더크다면!
			if (sharks.get(map[x][y]).z < sharks.get(idx).z) {
				// 죽은 샤크 저장
				dielist.add(map[x][y]);
				map[x][y] = idx;
			}else { //원래 있던 물고기가 더 큰경우
				dielist.add(idx);
			}
		}

	}

	static int doCheckcol(int col) {
		int idx = -1;
		int mincol = 1000;
		for (int i = 0; i < sharks.size(); i++) {
			// 같은 열에 있다
			if (col == sharks.get(i).y) {
				// 땅과 가깝다면.
				if (mincol > sharks.get(i).x) {
					mincol = sharks.get(i).x;
					idx = i;
				}
			}
		}

		return idx;
	}

	static class shark {
		int x;
		int y;
		int s;
		int d;
		int z;

		public shark(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("shark [x=").append(x).append(", y=").append(y).append(", s=").append(s).append(", d=")
					.append(d).append(", z=").append(z).append("]");
			return builder.toString();
		}

	}
}
