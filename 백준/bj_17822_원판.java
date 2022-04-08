
import java.util.*;
import java.io.*;

//구현 시뮬
//회전하고 인접한숫자 지우기
//dfs로 인접한거 찾기 모듈연산으로 범위잘정하기
public class bj_17822_원판 {

    static int[][] circleMap;
    static int N, M, T, ans;
    static boolean isFindNum=false;
    static int []dx={0,1,-1,0};
    static int []dy={1,0,0,-1};
    static boolean visit[][];

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        T = stoi(st.nextToken());
        circleMap = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                circleMap[i][j] = stoi(st.nextToken());
            }
        }

        //회전
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(in.readLine());
            int x=stoi(st.nextToken());
            int d=stoi(st.nextToken());
            int k=stoi(st.nextToken());
            doRotate(x,d,k);

            //원판에 수가 남아있는지 여부
            if(!isNum()){
                break;
            }
            isNearRemove();

        }

        //원판의 총합
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(circleMap[i][j]!=-1)
                    ans+=circleMap[i][j];
            }
        }
        System.out.println(ans);
    }
    private static void printmap(){
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(circleMap[i]));
        }
    }

    private static boolean isNum(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(circleMap[i][j]!=-1)
                   return true;
            }
        }
        return false;
    }

    private static void isNearRemove(){

        boolean check=false;
        visit=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                isFindNum=false;

                if(circleMap[i][j]!=-1){
                    dfs(i,j,circleMap[i][j]);
                }

                if(isFindNum){
                    circleMap[i][j]=-1;
                    check=true;
                }
            }
        }

        if(!check){

            doCalAvg();
        }

    }

    private static void dfs(int x, int y, int num) {

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=(y+dy[i])%M;

            if(ny<0){
                ny=M-1;
            }

            if(0<=nx && nx<N && 0<=ny && ny<M ){
                if(circleMap[nx][ny]==num){
                    isFindNum=true;
                    circleMap[nx][ny]=-1;
                    dfs(nx,ny,num);
                }
            }
        }
    }



    private static void doCalAvg(){

        double res=0;
        int count=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(circleMap[i][j]!=-1){
                    res+=circleMap[i][j];
                    count++;
                }
            }
        }

        double avg=res/count;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(circleMap[i][j] != -1){
                    if(avg < circleMap[i][j]){
                        circleMap[i][j] -= 1;
                    }else if(avg > circleMap[i][j]){
                        circleMap[i][j] += 1;
                    }
                }
            }
        }

    }

    private static void doRotate(int x, int d, int k) {

        k %= M;
        //번호의 배수의 원판 회전
        for (int i = 1; i <= N; i++) {
            if(i%x==0){
                for (int a = 0; a < k; a++) {
                    int[] target = circleMap[i-1];

                    if (d == 0) //시계
                    {
                        int temp = target[M - 1];
                        for (int j = M - 2; j >= 0; j--) {
                            target[j + 1] = target[j];
                        }
                        target[0]=temp;
                    } else {
                        int temp=target[0];
                        for(int j=0;j<M-1;j++){
                            target[j]=target[j+1];
                        }
                        target[M-1]=temp;
                    }
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

