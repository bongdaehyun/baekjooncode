import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_2352_반도체설계 {

	public static void main(String[] args)throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		StringTokenizer st=new StringTokenizer(in.readLine());
		int arr[]=new int[n];
		int LIS[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		int size=0;
		for(int i=0;i<n;i++) {
			int temp=Arrays.binarySearch(LIS, 0, size, arr[i]);
			temp=Math.abs(temp)-1;
			LIS[temp]=arr[i];
			if(temp==size)++size;
		}
		System.out.println(size);
		in.close();

	}

}
