package a0218_algo;

/*
5 5
.XX..
..X..
.....
...X.
...X.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_식당예제 {
	static boolean visited[][];
	static int R, C, ans;
	static boolean[][] map;


	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s[] = in.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s1=in.readLine();
			for(int j=0;j<s1.length();j++) {
				if(s1.charAt(j)=='x')
					map[i][j]=true;
			}
		}
		//for(boolean[] m:map)System.out.println(Arrays.toString(m));

		for(int i=0;i<R;i++)
			setPipe(i,0);
		System.out.println(ans);
		in.close();
	}

	static boolean setPipe(int x,int y) {
		for(int d=-1;d<2;d++) {
			int nx=x+d;
			int ny=y+1;
			if(0<=nx&&nx<R &&!map[nx][ny])
			{
				if(ny==C-1) {
					ans++;
					return true;
				}
				map[nx][ny]=true;
				if(setPipe(nx, ny))
					return true;
			}
		}
		return false;
		
	}

	
}
