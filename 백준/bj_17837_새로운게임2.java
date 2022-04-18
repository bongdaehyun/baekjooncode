import java.util.*;
import java.io.*;

public class bj_17837_새로운게임2 {

    //동서남북
    static int dx[]={0,0,0,-1,1};
    static int dy[]={0,1,-1,0,0};
    static int ans,N,K;
    static ArrayList<Chess> chesses;
    static int [][]maps;
    static ArrayList<Integer> boards[][];

    //흰 0 빨 1 파 2
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());

        N=stoi(st.nextToken());
        K=stoi(st.nextToken());

        chesses = new ArrayList<>();

        boards = new ArrayList[N][N];
        maps = new int[N][N];

        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
                boards[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<N;i++){
            String s[]=in.readLine().split(" ");
            for(int j=0;j<N;j++){
                maps[i][j]=stoi(s[j]);
            }
        }

        for(int k=0;k<K;k++){
            st=new StringTokenizer(in.readLine());
            int x=stoi(st.nextToken());
            int y=stoi(st.nextToken());
            int d=stoi(st.nextToken());

            boards[x-1][y-1].add(k);
            chesses.add(new Chess(x-1,y-1,d));
        }

        while(ans<=1000){
            ans++;
            if(!startGame()){
                break;
            }
        }

        System.out.println(ans>1000 ? -1 : ans);
    }

    private static boolean startGame(){
        for(int i=0;i<chesses.size();i++){
            Chess chess = chesses.get(i);
            //Move map
            int nx=chess.x+dx[chess.d];
            int ny=chess.y+dy[chess.d];
            int x=chess.x;
            int y=chess.y;

            //범위를 벗어나는 경우 (파랑색)
            if(0> nx || nx >= N || 0 > ny || ny >= N || maps[nx][ny]==2){
                if(chess.d == 1){
                    chess.d = 2;
                }else if(chess.d == 2){
                    chess.d = 1;
                }else if(chess.d == 3){
                    chess.d = 4;
                }else{
                    chess.d = 3;
                }

                int nnx = x + dx[chess.d];
                int nny = y + dy[chess.d];

                if(0> nnx || nnx >= N || 0 > nny || nny >= N || maps[nnx][nny]==2) continue;
                //파란색이 아닌 경우 이동후 반복
                if(maps[nnx][nny] != 2){
                    i--;
                    continue;
                }

            }else if(maps[nx][ny] == 0 || maps[nx][ny] == 1){
                boolean flag = false;
                Deque<Integer> q = new ArrayDeque<>();

                //현재 말 포함 위에 있는 말들 선별
                for(int j=0;j<boards[x][y].size();j++){
                    int idx = boards[x][y].get(j);

                    if(idx == i){
                        flag=true;
                        q.add(i);
                        boards[x][y].remove(j);
                        j--;
                        continue;
                    }
                    if(flag){
                        chesses.get(idx).x = nx;
                        chesses.get(idx).y = ny;
                        q.add(idx);
                        boards[x][y].remove(j);
                        j--;

                    }

                }

                chess.x = nx;
                chess.y = ny;

                if(maps[nx][ny] == 0){
                    while(!q.isEmpty()){
                        int num = q.poll();
                        boards[nx][ny].add(num);
                    }
                }else{
                    while(!q.isEmpty()){
                        int num = q.pollLast();
                        boards[nx][ny].add(num);
                    }
                }

                if(boards[nx][ny].size() >= 4){
                    return false;
                }
            }
        }
        return true;
   }



    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    static class Chess{
        int x;
        int y;
        int d;

        public Chess(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;

        }
    }
}
