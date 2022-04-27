import java.util.*;
import java.io.*;

// TODO : remove를 안하게끔 해야됨
public class bj_23290_마법상어와복제 {

    static int M,S,time,maxS;
    static ArrayList<fish> maps[][];
    static int dx[]={0,-1,-1,-1,0,1,1,1};
    static int dy[]={-1,-1,0,1,1,1,0,-1};
    static int sharkdx[]={0,-1,0,1,0};
    static int sharkdy[]={0,0,-1,0,1};

    static ArrayList<fish> fishs;
    static int fishsmell[][];
    static int shark[];
    static int picks[];
    static PriorityQueue<ArrayList<int[]>> pq = new PriorityQueue<>(new Comparator<ArrayList<int[]>>() {
        @Override
        public int compare(ArrayList<int[]> o1, ArrayList<int[]> o2) {
            return Integer.compare(o1.get(o1.size()-1)[0],o2.get(o2.size()-1)[0]);
        }
    });


    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        picks = new int[3];
        shark = new int[2];
        fishsmell = new int[4][4];
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                fishsmell[i][j]=-5;
            }
        }

        maps= new ArrayList[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)
                maps[i][j] = new ArrayList<>();
        }
        fishs = new ArrayList<>();

        //물고기
        for(int m=0;m<M;m++){
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fishs.add(new fish(x-1,y-1,d-1,false));
            maps[x-1][y-1].add(new fish(x-1,y-1,d-1,false));
        }

        //상어
        st = new StringTokenizer(in.readLine());
        shark[0] = Integer.parseInt(st.nextToken())-1;
        shark[1] = Integer.parseInt(st.nextToken())-1;

        while(S-->0){
            moveFish();
            time++;
            maxS=0;
            moveShark(0);
            ArrayList<int[]> temp=pq.poll();
            //죽은 물고기 제거
            for(int i=0;i<temp.size()-1;i++){
                fishsmell[temp.get(i)[0]][temp.get(i)[1]] = time;
                if(maps[temp.get(i)[0]][temp.get(i)[1]].isEmpty())continue;
                maps[temp.get(i)[0]][temp.get(i)[1]].clear();
            }
            //상어 이동
            String str[]=String.valueOf(temp.get(temp.size()-1)[0]).split("");
            for(int k=0;k<3;k++){
                shark[0]+=sharkdx[Integer.parseInt(str[k])];
                shark[1]+=sharkdy[Integer.parseInt(str[k])];
            }

            removesmell();
            copyFish();
        }
        System.out.println(fishs.size());
        //sumFish();
    }

    static void removesmell(){

        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                if(fishsmell[i][j]==time-2){
                    fishsmell[i][j]=-5;
                }
            }
        }
    }

    static void copyFish(){
        //복제마법
        for(fish f : fishs){
            maps[f.x][f.y].add(f);
        }
        fishs.clear();

        //모든 물고기 현재 위치 복사
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                for(int k=0; k < maps[i][j].size(); k++){
                    if(maps[i][j].get(k).check){
                        maps[i][j].get(k).check=false;
                    }
                    fishs.add(maps[i][j].get(k));
                }
            }
        }
    }


    static void moveShark(int cnt){

        if(cnt==3){
            int sx = shark[0];
            int sy = shark[1];
            String key="";
            ArrayList<int []>temp = new ArrayList<>();
            boolean visit[][] = new boolean[4][4];


            for(int i=0;i<picks.length;i++){
                key += picks[i];
                sx += sharkdx[picks[i]];
                sy += sharkdy[picks[i]];

                if(0 > sx || sx >=4 || 0> sy || sy >=4) return;
                if(visit[sx][sy]) continue;
                visit[sx][sy]=true;
                //해당 지역에 있는 모든 물고기 (죽은 물고기)
                for(int j=0;j<maps[sx][sy].size();j++){
                    temp.add(new int[]{maps[sx][sy].get(j).x,maps[sx][sy].get(j).y});
                }
            }
            temp.add(new int[]{Integer.parseInt(key)});
            if(temp.size() > maxS){
                maxS = temp.size();
                pq.clear();
                pq.add(temp);
            }else if(temp.size()==maxS){
                pq.add(temp);
            }
            return;
        }

        for(int k=1;k<=4;k++){
            picks[cnt]=k;
            moveShark(cnt+1);
        }
    }

    static void moveFish(){

        ArrayList<fish> copy[][] = new ArrayList[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)
                copy[i][j] = new ArrayList<>();
        }


        for(int x =0;x<4;x++){
            for(int y=0;y<4;y++){

                for(int i=0;i<maps[x][y].size();i++){
                    fish f = maps[x][y].get(i);
                    if(f.check)continue;
                    int nx = f.x +dx[f.d];
                    int ny = f.y +dy[f.d];

                    if(isMove(nx,ny)){
                        boolean flag = false;
                        //반시계
                        int nd = f.d -1;
                        if(nd == -1){
                            nd=7;
                        }
                        while(nd != f.d){
                            int mx = f.x + dx[nd];
                            int my = f.y + dy[nd];
                            if(!isMove(mx,my)){
                              //  maps[x][y].remove(i);
                                copy[mx][my].add(new fish(mx,my,nd,true));
                               // i--;
                                flag = true;
                                break;
                            }

                            nd = nd-1;
                            if(nd == -1){
                                nd=7;
                            }
                        }

                        if(!flag)
                            copy[f.x][f.y].add(new fish(f.x,f.y,f.d,true));
                    }else{
                      //  maps[x][y].remove(i);
                        copy[nx][ny].add(new fish(nx,ny,f.d,true));
                     //   i--;
                    }

                }
            }
        }

//        for(int i=0;i<4;i++){
//            for(int j=0;j<4;j++)
//                copy[i][j] = maps[i][j];
//        }
        maps = copy;
    }

    private static void sumFish(){
        int sum=0;

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                sum+= maps[i][j].size();
            }
        }
        System.out.println(sum);
    }

    static boolean isMove(int nx,int ny){
        return 0> nx|| nx >=4 || 0> ny || ny >=4 || fishsmell[nx][ny] !=-5 || (shark[0] == nx && shark[1] == ny);
    }

    static class fish{
        int x;
        int y;
        int d;
        boolean check; //이동한 물고기

        public fish(int x, int y, int d,boolean check){
            this.x=x;
            this.y=y;
            this.d=d;
            this.check=check;
        }
    }
}
