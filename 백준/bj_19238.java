import java.util.*;
import java.io.*;

public class bj_19238 {
    static int n,m,fuel;
    static int map[][];
    static int dx[]={0,1,-1,0};
    static int dy[]={1,0,0,-1};

    public static void main(String[] args)throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        fuel=Integer.parseInt(st.nextToken());

        map=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(in.readLine());
        int sx=Integer.parseInt(st.nextToken())-1;
        int sy=Integer.parseInt(st.nextToken())-1;

        ArrayList<guest>guests=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken())-1;
            int y=Integer.parseInt(st.nextToken())-1;
            int ex=Integer.parseInt(st.nextToken())-1;
            int ey=Integer.parseInt(st.nextToken())-1;
            guests.add(new guest(x,y,ex,ey));
        }
        boolean flag=false;
        while(true){

            if(guests.isEmpty()){
                flag=true;
                break;
            }


            //거리 계산
            ArrayList<guest>temp=new ArrayList<>();
            int mind=Integer.MAX_VALUE;

            for(int i=0;i<guests.size();i++){
                //System.out.println(guests.get(i).toString());
                int d=cal_d(sx,sy,guests.get(i).sx,guests.get(i).sy);
                if(d==-1){
                    System.out.println(-1);
                    return;
                }
                if(mind>d){
                    temp.clear();
                    mind=d;
                    temp.add(guests.get(i));
                }else if(mind==d){
                    temp.add(guests.get(i));
                }

            }
            temp.sort(new Comparator<guest>() {
                @Override
                public int compare(guest o1, guest o2) {
                    int a=o1.sx-o2.sx;
                    if(a==0)
                        return o1.sy-o2.sy;
                    return a;
                }
            });
            //이동하는 도중 없다.
            if(fuel-mind<=0){
                break;
            }
            guest g=temp.get(0);
            guests.remove(g);

            int ed=cal_d(g.sx,g.sy,g.ex,g.ey);
            if(fuel-mind-ed<0){
                break;
            }else{
                fuel=fuel-mind-ed;
                fuel+=ed*2;
            }
            sx=g.ex;
            sy=g.ey;

        }

        if(flag)
            System.out.println(fuel);
        else
            System.out.println(-1);
    }
    public static int cal_d(int sx,int sy,int ex,int ey){
        int d=0;
        boolean check=false;
        Deque<int []>q=new ArrayDeque<>();
        boolean visit[][]=new boolean[n][n];
        q.add(new int[]{sx,sy,0});
        visit[sx][sy]=true;
        while(!q.isEmpty()){
            int cnt[]=q.poll();
            if(cnt[0]==ex&&cnt[1]==ey){
                d=cnt[2];
                check=true;
                break;
            }
            for(int k=0;k<4;k++){
                int nx=cnt[0]+dx[k];
                int ny=cnt[1]+dy[k];

                if(0<=nx&&nx<n&&0<=ny&&ny<n&&!visit[nx][ny]){
                    if(map[nx][ny]==1)continue;
                    visit[nx][ny]=true;
                    q.add(new int[]{nx,ny,cnt[2]+1});
                }
            }
        }
        if(check)
            return d;
        else
            return -1;
    }

    public static class guest implements Comparator<guest>{
        int sx;
        int sy;
        int ex;
        int ey;

        guest(int sx,int sy,int ex,int ey){
            this.sx=sx;
            this.sy=sy;
            this.ex=ex;
            this.ey=ey;

        }

        @Override
        public String toString() {
            return "guest{" +
                    "sx=" + sx +
                    ", sy=" + sy +
                    ", ex=" + ex +
                    ", ey=" + ey +
                    '}';
        }

        @Override
        public int compare(guest o1, guest o2) {
            int a=o1.sx-o2.sx;
            if(a==0)
                return o1.sy-o2.sy;
            return a;
        }

    }
}
