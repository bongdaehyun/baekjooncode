import java.util.*;
import java.io.*;

public class bj_20056 {
    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};
    static int N,M,K;
    static Deque<fireball> map[][];

    public static void main(String[] args)throws Exception{
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());

        N=Integer.parseInt(st.nextToken()); //맵 크기
        M=Integer.parseInt(st.nextToken()); //파이어볼 개수
        K=Integer.parseInt(st.nextToken()); // 명령 수
        map=new ArrayDeque[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=new ArrayDeque<>();
            }
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            map[x-1][y-1].add(new fireball(m,s,d));
        }

        for(int i=0;i<K;i++){
            move();
        }
        int ans=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j].size()>0){
                   for(fireball fire : map[i][j]){
                       ans+=fire.m;
                   }
                }
            }
        }
        System.out.println(ans);
    }

    private static void move() {
        Deque<fireball>[][] copy=new ArrayDeque[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                copy[i][j]=new ArrayDeque<>();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j].size()>0){

                    for(fireball fire: map[i][j]){
                        int s= fire.s%N;
                        //System.out.println("i+j = " + s+" "+i+","+j);
                        int nx=(i+s*dx[fire.d]+N)%N;
                        int ny=(j+s*dy[fire.d]+N)%N;
                        //System.out.println("nx+ny = " + nx+","+ny);

                        copy[nx][ny].add(fire);
                    }
                }
            }
        }
        map=copy;
        split_fireball();
    }

    private static void split_fireball() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j].size()>=2){
                    int summ=0;
                    int sums=0;
                    int count=map[i][j].size();
                    boolean even=false;
                    boolean odd=false;

                    for(fireball fire:map[i][j]) {
                        summ += fire.m;
                        sums += fire.s;
                        if(fire.d%2==0){
                            even=true;
                        }else{
                            odd=true;
                        }
                    }
                    map[i][j].clear();
                    if(summ<5) continue;
                    summ/=5;
                    sums/=count;

                    //홀수+짝수가 섞여잇음
                    if(even && odd){
                        for(int k=1;k<8;k+=2){
                            map[i][j].add(new fireball(summ,sums,k));
                        }
                    }else{
                        for(int k=0;k<=6;k+=2){
                            map[i][j].add(new fireball(summ,sums,k));
                        }
                    }

                }
            }
        }
    }

    public static class fireball{

        int m;
        int s;
        int d;

        fireball(int m,int s,int d){

            this.m=m;
            this.s=s;
            this.d=d;
        }

        @Override
        public String toString() {
            return "fireball{" +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }
}
