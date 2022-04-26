import java.util.*;
import java.io.*;

public class bj_21611_마법상어와블리자드 {
    static int N,M,ans;
    static int [][]maps;
    static int dx[] = {0,-1,1,0,0};
    static int dy[] = {0,0,0,-1,1};
    static int mx[] = {0,1,0,-1};
    static int my[] = {-1,0,1,0};

    static int []board;

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][N];

        board = new int[N*N-1];


        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int m=0;m<M;m++){
            st = new StringTokenizer(in.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            boom(d,s);
            //여기서 시간이 좀 오래걸릴거 같다. 시간초과면 바꿔야됨
            toArray(true);
            movebead();
            while(near4boom()){
                movebead();
            }
            changing();
            toArray(false);
            //System.out.println(Arrays.toString(board));
        }
        System.out.println(ans);
    }

    private static void toArray(boolean check){
        int cnt = 0, dir=0;
        int move = 1 , cornor =0;
        int sx = N/2;
        int sy = N/2;

        while(cnt <= N*N ){
            boolean flag = false;
            for(int i=0;i<move;i++) {
                sx +=  mx[dir%4];
                sy +=  my[dir%4];
                if(0 > sx || sx >= N || 0 > sy || sy >=N ){
                    flag = true;
                    break;
                }
                if(check)
                    board[cnt++] = maps[sx][sy];
                else
                    maps[sx][sy] = board[cnt++];
            }
            if( flag) break;
            dir++;
            cornor++;
            if(cornor == 2 ){
                move++;
                cornor = 0;
            }
        }
    }

    private static void movebead(){

        while(true){
            int size = board.length;
            boolean flag = false;
            int count =0;
            for(int i=0;i<size;i++){
                if(board[i] == -1){
                    count++;
                    flag = true;
                    for(int j=i;j<size-1;j++){
                        board[j] =board[j+1];
                    }
                    i--;
                }
            }
            for(int c=0;c<count;c++){
                board[--size] = 0;
            }
            if(!flag)break;
        }


    }
    private static boolean near4boom(){
        int count = 1;
        boolean flag = false;

        for(int i=0;i<board.length-1;i++){
            if(board[i] == -1 && board[i] == 0){
                count = 0;
                continue;
            }
            if(board[i] == board[i+1]){
                count++;
            }else{
                if(count >= 4) {
                    ans += count*board[i];
                    int idx = i;
                    for(int c = 0; c < count; c++){
                        board[idx--] = -1;
                    }
                    flag = true;
                }
                count=1;
            }

        }
        return flag;
    }

    //TODO:1차원 배열 터트리기 로 수정해야됨
    private static void boom(int d, int s){
        int x = (N)/2;
        int y = (N)/2;

        for(int i=0;i<s;i++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            //파괴된 상태
            maps[nx][ny]=-1;
            x = nx;
            y = ny;
        }
    }

    private static void changing(){
        int count = 1;
        int copy[] = new int[board.length];
        int idx =0;
        for(int i=0;i<board.length-1;i++){
            if(board[i] == board[i+1]){
                count++;
            }else{
                if(idx >= board.length) break;
                copy[idx++] = count;
                if(idx >= board.length) break;
                copy[idx++] = board[i];

                count=1;
            }

        }
        board = copy;
    }
}
