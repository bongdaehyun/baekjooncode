import java.util.*;
import java.io.*;

public class bj_2310_어드벤처게임 {


    static ArrayList<roomInfo> roomList;
    static boolean visit[];
    static boolean ans;
    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            int n = stoi(in.readLine());
            roomList=new ArrayList<>();
            if(n==0){
                break;
            }
            ans=false;
            visit=new boolean[n];
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(in.readLine());
                String type=st.nextToken();
                int gold=stoi(st.nextToken());
                ArrayList<Integer>room=new ArrayList<>();
                while(true){
                    int roomnum = stoi(st.nextToken());
                    if(roomnum !=0 ){
                        room.add(roomnum-1);
                    }else break;
                }

                roomList.add(new roomInfo(type,gold,room));
            }
            isArriveRoom(0,n-1,0);
            System.out.println(ans ? "Yes" : "No");

        }
    }

    private static void isArriveRoom(int next,int end, int player_gold){
        if(ans){
            return;
        }

        if(roomList.get(next).type.equals("L")){
            if(player_gold < roomList.get(next).gold){
                player_gold = roomList.get(next).gold;
            }
        }else if(roomList.get(next).type.equals("T")){
            if(roomList.get(next).gold <= player_gold){
                player_gold-=roomList.get(next).gold;
            }else{
                ans=false;
                return ;
            }
        }


        if(next ==end){
            ans=true;
            return ;
        }

        visit[next]=true;

        for(int num = 0; num<roomList.get(next).rooms.size(); num++){
            int nextRoom=roomList.get(next).rooms.get(num);
            if(!visit[nextRoom]){
                isArriveRoom(nextRoom,end,player_gold);
            }
        }
        visit[next]=false;

    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    static class roomInfo{
        String type;
        int gold;
        ArrayList<Integer> rooms;

        public roomInfo(String type,int gold,ArrayList<Integer> rooms ){
            this.type=type;
            this.gold=gold;
            this.rooms=rooms;
        }
    }
}
