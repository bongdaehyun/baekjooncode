import java.util.*;
import java.io.*;

public class bj_2573_빙산 {

    static int map[][];
    static int res,N,M;
    static int dx[]={0,1,-1,0};
    static int dy[]={1,0,0,-1};

    public static void main(String[] args)throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        boolean isIce=false;
        N=stoi(st.nextToken());
        M=stoi(st.nextToken());
        map=new int[N][M];

        for(int i=0;i<N;i++){

            String s[]=in.readLine().split(" ");
            for(int j=0;j<s.length;j++){
                map[i][j]=stoi(s[j]);
            }
        }

        while(iceCheck()){

            if(divideChk()){
                isIce=true;
                break;
            }
            iceBreak();
            res++;
        }

        System.out.println(isIce ? res : 0);
    }


    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    private static int[][] generate_copyMap(int [][]map){
        int copymap[][]=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                copymap[i][j]=map[i][j] < 0 ? 0 : map[i][j];
            }
        }
        return copymap;
    }

    private static boolean iceCheck(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>0){
                    return true;
                }
            }
        }
        return false;
    }

    private static void iceBreak(){
        int [][]copymap=generate_copyMap(map);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>0){
                    int count=0;
                    for(int k=0;k<4;k++){
                        int nx=dx[k]+i;
                        int ny=dy[k]+j;

                        if(0 <= nx && nx < N && ny < M && 0 <= ny){
                            if(map[nx][ny]==0){
                                count++;
                            }
                        }
                    }

                    copymap[i][j]-=count;
                }
            }
        }
        map=generate_copyMap(copymap);

    }
    private static boolean divideChk(){
        boolean visit[][]=new boolean[N][M];

        int count=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]>0 && !visit[i][j]){
                    Deque<int []>q=new ArrayDeque<>();
                    q.offer(new int[]{i,j});
                    visit[i][j]=true;

                    while(!q.isEmpty()){
                        int []cnt=q.poll();

                        for(int k=0;k<4;k++){

                            int nx=cnt[0]+dx[k];
                            int ny=cnt[1]+dy[k];

                            if(0 <= nx && nx < N && ny < M && 0 <= ny && !visit[nx][ny]){
                                if(map[nx][ny]>0){
                                    visit[nx][ny]=true;
                                    q.offer(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    count++;
                }
            }
        }

        if(count>=2){
            return true;
        }
        return false;
    }
}
