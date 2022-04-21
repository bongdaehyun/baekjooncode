import java.util.*;
import java.io.*;


public class Solution_1949_등산로조성 {
    static int N,K,ans;
    static int dx[]={0,1,-1,0};
    static int dy[]={1,0,0,-1};
    static int[][]maps;
    static ArrayList<int []> hlist;

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(in.readLine());
            hlist = new ArrayList<>();
            ans=0;
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            maps = new int[N][N];
            int maxH = 0;


            for(int i=0;i<N;i++){
                st = new StringTokenizer(in.readLine());
                for(int j=0;j<N;j++){
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    if(maxH < maps[i][j]){
                        hlist.clear();
                        hlist.add(new int[]{i,j});
                        maxH = maps[i][j];
                    }else if(maxH == maps[i][j]){
                        hlist.add(new int[]{i,j});
                    }
                }
            }

            for(int k=0; k<=K;k++){
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(maps[i][j] -k <0) continue;
                        else maps[i][j] -=k;

                        //봉우리 별로 완탐
                        for(int []h : hlist){
                            dfs(h[0],h[1],1,maps);
                        }

                        maps[i][j] +=k;
                    }
                }

            }
            System.out.println("#"+t+" "+ans);
        }



    }


    private static void dfs(int x, int y , int size ,int [][]list){

        if(ans < size){
            ans = size;
        }

        for(int d=0;d<4;d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(0<= nx && nx < N && 0<=ny && ny < N && list[nx][ny] < list[x][y]) {
                dfs(nx,ny,size+1,list);
            }
        }

    }

}
