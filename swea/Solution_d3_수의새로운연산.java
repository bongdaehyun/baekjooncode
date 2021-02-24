import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution_d3_수의새로운연산 {
	static int []s=new int[300];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1493.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, int[]> map = new HashMap<>();

		int T = stoi(in.readLine());
		
		s[1]=1;//초기값
		for(int i=2;i<s.length;i++) {
			s[i]=s[i-1]+i-1;
		}
		
		for (int t = 1; t <= T; t++) {
			String s2[] = in.readLine().split(" ");
			int p = stoi(s2[0]);
			int q = stoi(s2[1]);
			int res=0;
			
			//p값의 r,c
			int tmp[]=getvalue(p);
			//q값의 r,c
			int tmp1[]=getvalue(q);
			int nx=tmp[0]+tmp1[0];
			int ny=tmp[1]+tmp1[1];
			int idx=nx+ny-1;
			
			res=s[idx]+ny-1;
			System.out.println("#" + t + " " + res);
		}
	}
	static int [] getvalue(int x) {
		int sy=0;
		int d=0;
		for(int i=1;i<s.length;i++) {
			if(s[i]>x) {
				sy=i-1;
				d=x-s[i-1];
				break;
			}
		}
		return new int[]{sy-d,1+d};
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
