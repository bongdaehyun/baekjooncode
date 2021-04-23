package a0423_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int [][]gears;
	
	public static void main(String[] args)throws Exception {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++) {
			int k=Integer.parseInt(in.readLine());
			gears=new int[4][8];
			
			//톱니바퀴 입력
			StringTokenizer st=null;
			for(int i=0;i<4;i++) {
				st=new StringTokenizer(in.readLine());
				for(int j=0;j<8;j++)
					gears[i][j]=Integer.parseInt(st.nextToken());
			}
			//이동 방법 입력
			for(int i=0;i<k;i++) {
				st=new StringTokenizer(in.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int []state=getState(a, b);
				dorotate(state);
			}
			
			int result=0;
			for(int i=0;i<gears.length;i++) {
				result+=gears[i][0]*Math.pow(2,i);
			}
			System.out.println("#"+t+" "+result);
		}
		
		
		in.close();

	}
	//자석마다의 방향 얻기
	static int[] getState(int a,int b) {
		int []state=new int[4];
		state[a-1]=b;
		
		//left 
		for(int i=a-1;i>0;i--) {
			//극이 다르면.
			if(gears[i-1][2]!=gears[i][6])
				state[i-1]=state[i]*-1;
		}
		
		//right
		for(int i=a-1;i<3;i++) {
			if(gears[i+1][6]!=gears[i][2])
				state[i+1]=state[i]*-1;
		}
		return state;
	}
	
	static void dorotate(int state[]) {
		for(int i=0;i<state.length;i++) {
			//시계
			if(state[i]==1) {
				int temp=gears[i][7];
				for(int j=gears[i].length-2;j>=0;j--) {
					gears[i][j+1]=gears[i][j];
				}
				gears[i][0]=temp;
			}
			//반시계
			else if(state[i]==-1) {
				int temp=gears[i][0];
				for(int j=1;j<8;j++) {
					gears[i][j-1]=gears[i][j];
				}
				gears[i][7]=temp;
			}
		}
	}
}
