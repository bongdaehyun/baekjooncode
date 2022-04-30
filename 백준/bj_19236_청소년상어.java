import java.io.*;
import java.util.*;

public class bj_19236_청소년상어 {

    static int []dx={-1,-1,0,1,1,1,0,-1};
    static int []dy={0,-1,-1,-1,0,1,1,1};
    static int [][]maps;
    static fish []fishs;
    static int ans;

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        maps = new int[4][4];
        fishs = new fish[17];

        for(int i=0;i<4;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<4;j++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                maps[i][j] = a;
                fishs[a] = new fish(a,b-1,i,j,true);
            }
        }
        //처음 시작 0 0 물고기 먹으면서
        int dir = fishs[maps[0][0]].dir;
        fishs[maps[0][0]].alive = false;
        int num = maps[0][0];
        maps[0][0] = -1;

        moveShark(0,0,dir,num,maps,fishs);

        System.out.println(ans);
    }


    //TODO : maps 이동이 이상함
    private static void moveShark(int x, int y,int dir, int eat, int[][]arr, fish[] fishlist){
        ans = Math.max(ans,eat);

        movefish(fishlist,arr);
        //3칸 이동
        for(int i=1;i<4;i++){
            int nx = x + dx[dir]*i;
            int ny = y + dy[dir]*i;
            //빈칸 or 격자밖이 아니면 상어 이동
            if( 0 <= nx && nx < 4  && 0 <= ny && ny < 4 && arr[nx][ny] != 0 ){
                int [][]copyArr = arrCopy(arr);
                fish[] copyFish = fishCopy(fishlist);
                //먹힌 물고기
                int num = copyArr[nx][ny];
                copyFish[num].alive = false;
                copyArr[nx][ny] = -1;
                copyArr[x][y] = 0;
                int nd = copyFish[num].dir;
                moveShark(nx,ny,nd,eat+num,copyArr,copyFish);
            }
        }
    }

    private static fish[] fishCopy(fish[] fishs){
        fish []copy = new fish[17];

        for(int i=1;i<17;i++){
            copy[i] = new fish(fishs[i].num, fishs[i].dir , fishs[i].x , fishs[i].y,fishs[i].alive);
        }
        return copy;
    }

    private static int[][] arrCopy(int [][]arr){
        int [][]copy = new int[arr.length][arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }


    //번호 낮은 물고기순으로 이동
    private static void movefish(fish[] fishlist, int[][] map){
       for(int i=1;i<17;i++){
           if(!fishlist[i].alive)continue;

           int nx =0 ,ny = 0;
           int d = fishlist[i].dir;

          for(int j=0;j<8;j++){

              nx = fishlist[i].x + dx[d];
              ny = fishlist[i].y + dy[d];
              fishlist[i].dir=d;
              //상어 X 격자 안
              if( 0 <= nx && nx < 4 && 0<= ny && ny < 4 && map[nx][ny] != -1){
                  if(map[nx][ny] == 0){
                      map[fishlist[i].x][fishlist[i].y] = 0;
                      fishlist[i].x = nx;
                      fishlist[i].y = ny;
                      map[nx][ny] = i;
                  }else{
                      int changefish = map[nx][ny];

                      fishlist[changefish].x = fishlist[i].x;
                      fishlist[changefish].y = fishlist[i].y;
                      map[fishlist[changefish].x][fishlist[changefish].y] = changefish;

                      fishlist[i].x = nx;
                      fishlist[i].y = ny;
                      map[nx][ny] = i;

                  }

                  break;
              }else{
                  d=(d+1)%8;
              }

          }

       }
    }


    static class fish{
        int num;
        int x;
        int y;
        int dir;
        boolean alive;

        public fish(int num,int dir,int x, int y ,boolean alive){
            this.num = num;
            this.dir = dir;
            this.x = x;
            this.y = y;
            this.alive = alive;
        }
    }


}
