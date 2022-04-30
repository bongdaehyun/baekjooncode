import java.io.*;
import java.util.*;

//1번 상어만 격자에 남게되는 시간. 1000 넘으면 -1
public class bj_19237_어른상어 {

    static int N,M,k;
    static Room [][]rooms;
    static int dx[] = {0,-1,1,0,0};
    static int dy[] = {0,0,0,-1,1};
    static Shark []sharks;

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        rooms = new Room[N][N];
        sharks = new Shark[M+1];
        int time = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                int n = Integer.parseInt(st.nextToken());
                rooms[i][j] = new Room(n,0,0);
                if(n != 0){
                    sharks[n] = new Shark(i,j,n,null,0,true);
                }
            }
        }


        int d[] = new int[M+1];
        //각 상어 방향
        st = new StringTokenizer(in.readLine());
        for(int i=1;i<=M;i++){
            d[i]=Integer.parseInt(st.nextToken());
        }


        //상어 우선순위 정보
        for(int i=1;i<=M;i++){
            int temp[][] = new int[5][5];
            for(int j=1; j<=4; j++){
                st = new StringTokenizer(in.readLine());
                for(int k=1;k<=4;k++){
                    temp[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sharks[i] = new Shark(sharks[i].x,sharks[i].y,i+1,temp,d[i],true);
        }

        while(time < 1000){
            dowmSmell();
            //1. 자신의 위치에 자신의 냄새뿌리기
            spreedSmell();
            //2.1초마다 모든 상어가 동시에 상하좌우로 이동
            time++;
            moveShark();

            //1번 만 남으면 종료
            if(end()){
                System.out.println(time);
                return;
            }
        }

        System.out.println(-1);
    }
    private static boolean end(){

        boolean check = true;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(rooms[i][j].num > 1 ){
                    check = false;
                }
            }
        }

        return check;
    }

    //정해진 방향의 우선순위 대로 움직임 상어들 이동
    private static void moveShark(){

        for(int i=1;i<=M;i++){
            if(!sharks[i].alive)continue;
            boolean flag = false;
            int nx =0, ny =0, nd =0;
            //보는 방향에서 우선순위 탐색 아무 냄새 없는 칸부터
            for(int k =1; k<=4; k++){
                nd = sharks[i].dirs[sharks[i].d][k];
                nx = sharks[i].x + dx[nd];
                ny = sharks[i].y + dy[nd];
                //경계를 나가지 않고 냄새없는곳
                if(0<=nx && nx < N && 0 <= ny && ny < N && rooms[nx][ny].smell == 0)
                {
                    flag = true;
                    break;
                }
            }

            //냄새 없는 칸이 없는 경우
            if(!flag){
                for(int k=1;k<=4;k++){
                    nd = sharks[i].dirs[sharks[i].d][k];
                    nx = sharks[i].x + dx[nd];
                    ny = sharks[i].y + dy[nd];

                    //자신의 냄새가 남아 있는 곳으로
                    if(0<=nx && nx < N && 0 <= ny && ny < N && rooms[nx][ny].smellNum == i)
                    {
                        break;
                    }
                }

            }
            //가는 곳이 빈칸
            if(rooms[nx][ny].num == 0){
                //이전자리 빈칸
                rooms[sharks[i].x][sharks[i].y].num = 0;
                //이동한 자리 처리
                rooms[nx][ny].num = i;
                //상어 정보 갱신
                sharks[i].x = nx;
                sharks[i].y = ny;
                sharks[i].d = nd;
            }else{ // 이미 가는 곳에는 번호가 낮은 번호부터 이동하기 때문에 죽음
                rooms[sharks[i].x][sharks[i].y].num = 0;
                sharks[i].alive = false;
            }

        }



    }

    private static void spreedSmell(){
        for(int i=1;i<=M;i++){
            if(!sharks[i].alive)continue;
            rooms[sharks[i].x][sharks[i].y].smell = k;
            rooms[sharks[i].x][sharks[i].y].smellNum = i;
            rooms[sharks[i].x][sharks[i].y].num = i;
        }
    }
    private static void dowmSmell(){

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(rooms[i][j].smell > 0)
                {
                    rooms[i][j].smell -=1;
                }
            }
        }
    }

    static class Shark{
        int num;
        int dirs[][];
        int d;
        int x;
        int y;
        //생사여부
        boolean alive;

        public Shark(int x,int y,int num, int dirs[][],int d,boolean alive){
            this.num = num;
            this.dirs = dirs;
            this.d = d;
            this.x = x;
            this.y = y;
            this.alive = alive;
        }
    }

    static class Room{
        //상어 번호 빈칸이면 0
        int num;
        //냄새 흔적
        int smell;
        int smellNum;

        public Room(int num,int smell,int smellNum){
            this.num = num;
            this.smell = smell;
            this.smellNum = smellNum;
        }
    }
}
