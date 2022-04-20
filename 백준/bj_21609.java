import java.util.*;
import java.io.*;

public class bj_21609 {
    static int map[][];
    static int n,m;
    public static void main(String[] args)throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        rotate();
        printmap();
    }

    private static void rotate(){
        int [][]copy=new int[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                copy[n-j-1][i]=map[i][j];
            }
        }
        map=copy;
    }
    private static void printmap(){
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
}
