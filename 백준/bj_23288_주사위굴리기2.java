import java.util.*;
import java.io.*;

public class bj_23288_주사위굴리기2 {

//                2
//              4 1 3
//                5
//                6
    static int []dice = {2,1,5,6,4,3};
    //동서남북 0 1 2 3
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int N,M,K,ans;
    static int [][]board;


    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //처음은 동쪽
        int d = 0,x=0, y=0;

        while(K-->0){
            int temp[]=Move(x,y,d);
            x = temp[0];
            y = temp[1];
            d = temp[2];
        }
        System.out.println(ans);

    }

//    A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
//    A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
    private static int[] Move(int x,int y,int d){
        int nx = x + dx[d];
        int ny = y + dy[d];


        //지도밖으로 나간상황 - 이동방향 반대로한 다음 한칸 굴러간다.
        if(0 > nx || nx >= N || 0> ny || ny >= M){
            d= getD(d);
            nx = x + dx[d];
            ny = y + dy[d];
        }

        //주사위 돌리기
        moveDice(d);
        ans += getScore(nx,ny);

        if(dice[3] > board[nx][ny]){
            //시계
            if(d == 0 ){
                d=2;
            }else if(d == 1 ){
                d=3;
            }else if(d == 2 ){
                d=1;
            }else
                d=0;
        }else if(dice[3] < board[nx][ny]){
            //반시계
            if(d == 0 ){
                d=3;
            }else if(d == 1 ){
                d=2;
            }else if(d == 2 ){
                d=0;
            }else
                d=1;
        }


        return new int[]{nx,ny,d};
    }

    private static int getScore(int x, int y){
        int res = board[x][y];
        int count =1;
        boolean visit[][] = new boolean[N][M];
        Deque<int []>q= new ArrayDeque<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;

        while(!q.isEmpty()){
            int cnt[] = q.poll();

            for(int k=0;k<4;k++){
                int nx = cnt[0] + dx[k];
                int ny = cnt[1] + dy[k];
                if(0 > nx || nx >= N || 0> ny || ny >= M || visit[nx][ny])continue;
                if(board[nx][ny] != res) continue;
                q.add(new int[]{nx,ny});
                visit[nx][ny]= true;
                count++;
            }
        }


        return res*count;
    }

    private static void moveDice(int d){
        int []copy = new int[6];
        if(d == 0){
            copy[0]=dice[0];
            copy[5]=dice[1];
            copy[2]=dice[2];
            copy[4]=dice[3];
            copy[1]=dice[4];
            copy[3]=dice[5];
        }else if(d == 1){
            copy[0]=dice[0];
            copy[4]=dice[1];
            copy[2]=dice[2];
            copy[5]=dice[3];
            copy[3]=dice[4];
            copy[1]=dice[5];
        }else if(d ==2){
            copy[1]=dice[0];
            copy[2]=dice[1];
            copy[3]=dice[2];
            copy[0]=dice[3];
            copy[4]=dice[4];
            copy[5]=dice[5];
        }else{
            copy[3]=dice[0];
            copy[0]=dice[1];
            copy[1]=dice[2];
            copy[2]=dice[3];
            copy[4]=dice[4];
            copy[5]=dice[5];
        }
        dice = copy;
    }

    private static int getD(int d){

        if(d == 0){
            d=1;
        }else if(d == 1){
            d=0;
        }else if(d ==2){
            d=3;
        }else
            d=2;

        return d;
    }
}
