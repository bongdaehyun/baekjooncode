import java.util.*;
import java.io.*;


public class bj_17825_주사위윷놀이 {

    static Node maps[];
    static int move[], pick_horse[];
    static horse horses[];
    static boolean visit[];
    static int ans,temp;

    public static void main(String[] args)throws Exception {
        init();
        move = new int[10];
        pick_horse = new int[10];
        horses = new horse[4];
        horseInit();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        for(int i=0;i<10;i++){
            move[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
    }


    private static boolean isReach(int dice, int horse_idx){

        int cnt_idx = horses[horse_idx].idx;
        boolean cnt_flag = horses[horse_idx].flag;

        //도착 지점 말
        if(cnt_idx == 100){
            return true;
        }

        //주사위 만큼 이동
        for(int d=0;d<dice;d++){

            if(cnt_idx == 100){
                visit[horses[horse_idx].idx] =false;
                horses[horse_idx].idx = cnt_idx;
                horses[horse_idx].flag = cnt_flag;
                return true;
            }
            // 파란경로로 이동할 수 있다.
            if(cnt_idx == 5 || cnt_idx == 10 || cnt_idx == 15 ){
                if(cnt_flag){
                    cnt_idx = maps[cnt_idx].blue_idx;
                }else{
                    cnt_idx = maps[cnt_idx].red_idx;
                }
            }else{
                cnt_idx = maps[cnt_idx].red_idx;
            }

        }

        if(cnt_idx == 100){
            visit[horses[horse_idx].idx] =false;
            horses[horse_idx].idx = cnt_idx;
            horses[horse_idx].flag = cnt_flag;
            return true;
        }
        //주사위 눈금만큼 이동을 마친 뒤 파란경로로 가는지 여부
        if(cnt_idx == 5 || cnt_idx == 10 || cnt_idx == 15){
            cnt_flag = true;
        }

        //말을 이동을 마치는 다른말이 있으면 그말은 못간다
        if(visit[cnt_idx]){
            return false;
        }

        //말의 정보 갱신
        visit[horses[horse_idx].idx] =false;
        horses[horse_idx].idx = cnt_idx;
        horses[horse_idx].flag = cnt_flag;

        temp += maps[cnt_idx].num;
        visit[cnt_idx]=true;
        return true;
    }

    private static void dfs(int cnt){
        if(cnt == 10){
            temp =0;
            for(int i=0;i<10;i++){
                if(!isReach(move[i],pick_horse[i])){
                    horseInit();
                    return ;
                }
            }
            ans=Math.max(ans,temp);
            horseInit();
            return ;
        }


        //어떤 말을 움직일지 순열로 생성
        for(int i=0;i<4;i++){
            pick_horse[cnt] = i;
            dfs(cnt+1);
        }

    }

    private static void horseInit(){
        visit = new boolean[32];

        for(int i=0;i<4;i++){
            horses[i]= new horse(0,false);
        }
    }
    private static void init(){
        maps = new Node[32];

        //외각 맵
        for(int i=0;i<20;i++){
            maps[i]=new Node(i+1,0,i*2);
        }
        maps[5].blue_idx = 21;
        maps[10].blue_idx = 28;
        maps[15].blue_idx = 27;

        maps[21] = new Node(22,0,13);
        maps[22] = new Node(23,0,16);
        maps[23] = new Node(24,0,19);
        maps[24] = new Node(30,0,25);
        maps[25] = new Node(24,0,26);
        maps[26] = new Node(25,0,27);
        maps[27] = new Node(26,0,28);
        maps[28] = new Node(29,0,22);
        maps[29] = new Node(24,0,24);
        maps[30] = new Node(31,0,30);
        maps[31] = new Node(20,0,35);
        //도착
        maps[20] = new Node(100,-1,40);
    }

    static class horse{
        int idx;
        boolean flag;

        public horse(int idx, boolean flag){
            this.idx = idx;
            this.flag = flag;
        }
    }

    //연결 리스트를 활용
    static class Node{
        int red_idx;
        int blue_idx;
        int num;

        public Node(int red_idx, int blue_idx, int num){
            this.red_idx= red_idx;
            this.blue_idx= blue_idx;
            this.num= num;
        }
    }
}
