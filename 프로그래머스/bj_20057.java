
import java.util.*;
import java.io.*;
public class bj_20057 {
    static int dx[]={0,1,0,-1};
    static int dy[]={-1,0,1,0};
    static int N,ans;
    static int map[][];

    public static void main(String[] args)throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sx,sy;
        sx=sy=N/2;

        int count=0;
        int turn=0;
        int move=1;
        int cnt=0;

        while(true){
            if(sx==0&&sy==0)
                break;

            int nx=sx+dx[turn];
            int ny=sy+dy[turn];
            //System.out.println(nx+","+ny);
            move_sand(nx,ny,turn);
            cnt++;
            if(cnt==move){
                count++;
                turn=(turn+1)%4;
                cnt=0;
            }

            if(count==2){
                move++;
                count=0;

            }
            //System.out.println(cnt+","+turn+","+count+","+move);
            sx=nx;
            sy=ny;

        }
        System.out.println(ans);
    }

    private static void move_sand(int x,int y,int direction) {
        //System.out.println("현재위치 :"+x+","+y+","+direction);
        int v7=(int)(map[x][y]*0.07);
        int v2=(int)(map[x][y]*0.02);
        int v10=(int)(map[x][y]*0.1);
        int v1=(int)(map[x][y]*0.01);
        int v5=(int)(map[x][y]*0.05);
        int a=map[x][y]-2*(v1+v2+v7+v10)-v5;
        map[x][y]=0;
        if(direction==0){
            //7 top down
//            copy[x-1][y]=v7;
//            copy[x+1][y]=v7;
            for(int i=-1;i<2;i+=2){
                int nx=x+i;
                if(nx< 0 || nx>=N){
                    ans+=v7;
                }
                else{
                    map[nx][y]+=v7;
                }
            }

            //2 top donw
//            copy[x-2][y]=v2;
//            copy[x+2][y]=v2;
            for(int i=-2;i<=2;i+=4){
                int nx=x+i;
                if(nx< 0 || nx>=N){
                    ans+=v2;
                }
                else{
                    map[nx][y]+=v2;
                }
            }
            //10
//            copy[x-1][y-1]=v10;
//            copy[x+1][y-1]=v10;
            for(int i=-1;i<2;i+=2){
                int nx=x+i;
                int ny=y-1;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v10;
                }
                else{
                    map[nx][ny]+=v10;
                }
            }
            //1
//            copy[x-1][y+1]=v1;
//            copy[x+1][y+1]=v1;
            for(int i=-1;i<2;i+=2){
                int nx=x+i;
                int ny=y+1;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v1;
                }
                else{
                    map[nx][ny]+=v1;
                }
            }
            //5
            int n5y=y-2;
            if(n5y<0)
                ans+=v5;
            else{
                map[x][n5y]+=v5;
            }
            //A
            int nx=x+dx[direction];
            int nay=y+dy[direction];
            if(0<=nx &&nx<N && 0<=nay && nay<N)
                map[nx][nay]+=a;
            else
                ans+=a;

        }else if(direction==1){

//            map[x][y-1]=v7;
//            map[x][y+1]=v7;

            for(int i=-1;i<2;i+=2){
                int ny=y+i;
                if(ny< 0 || ny>=N){
                    ans+=v7;
                }
                else{
                    map[x][ny]+=v7;
                }
            }
//            map[x][y-2]=v2;
//            map[x][y+2]=v2;

            for(int i=-2;i<=2;i+=4){
                int ny=y+i;
                if(ny< 0 || ny>=N){
                    ans+=v2;
                }
                else{
                    map[x][ny]+=v2;
                }
            }
//            map[x+1][y-1]=v10;
//            map[x+1][y+1]=v10;
            for(int i=-1;i<2;i+=2){
                int nx=x+1;
                int ny=y+i;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v10;
                }
                else{
                    map[nx][ny]+=v10;
                }
            }
//            map[x-1][y-1]=v1;
//            map[x-1][y+1]=v1;
            for(int i=-1;i<2;i+=2){
                int nx=x-1;
                int ny=y+i;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v1;
                }
                else{
                    map[nx][ny]+=v1;
                }
            }
            //map[x+2][y]=v5;

            int n5x=x+2;
            if(n5x>=N)
                ans+=v5;
            else{
                map[n5x][y]+=v5;
            }

            int nx=x+dx[direction];
            int nay=y+dy[direction];
            if(0<=nx &&nx<N && 0<=nay && nay<N)
                map[nx][nay]+=a;
            else
                ans+=a;

        }else if(direction==2){
            for(int i=-1;i<2;i+=2){
                int nx=x+i;
                if(nx< 0 || nx>=N){
                    ans+=v7;
                }
                else{
                    map[nx][y]+=v7;
                }
            }
            //2 top donw
//            copy[x-2][y]=v2;
//            copy[x+2][y]=v2;
            for(int i=-2;i<=2;i+=4){
                int nx=x+i;
                if(nx< 0 || nx>=N){
                    ans+=v2;
                }
                else{
                    map[nx][y]+=v2;
                }
            }

            for(int i=-1;i<2;i+=2){
                int nx=x+i;
                int ny=y+1;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v10;
                }
                else{
                    map[nx][ny]+=v10;
                }
            }
            for(int i=-1;i<2;i+=2){
                int nx=x+i;
                int ny=y-1;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v1;
                }
                else{
                    map[nx][ny]+=v1;
                }
            }
            //5
            int n5y=y+2;
            if(n5y>=N)
                ans+=v5;
            else{
                map[x][n5y]+=v5;
            }
            //A
            int nx=x+dx[direction];
            int nay=y+dy[direction];
            if(0<=nx &&nx<N && 0<=nay && nay<N)
                map[nx][nay]+=a;
            else
                ans+=a;
        }else{
            // map[x][y-1]=v7;
//            map[x][y+1]=v7;

            for(int i=-1;i<2;i+=2){
                int ny=y+i;
                if(ny< 0 || ny>=N){
                    ans+=v7;
                }
                else{
                    map[x][ny]+=v7;
                }
            }
//            map[x][y-2]=v2;
//            map[x][y+2]=v2;

            for(int i=-2;i<=2;i+=4){
                int ny=y+i;
                if(ny< 0 || ny>=N){
                    ans+=v2;
                }
                else{
                    map[x][ny]+=v2;
                }
            }
//            map[x+1][y-1]=v10;
//            map[x+1][y+1]=v10;
            for(int i=-1;i<2;i+=2){
                int nx=x+1;
                int ny=y+i;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v1;
                }
                else{
                    map[nx][ny]+=v1;
                }
            }
//            map[x-1][y-1]=v1;
//            map[x-1][y+1]=v1;
            for(int i=-1;i<2;i+=2){
                int nx=x-1;
                int ny=y+i;
                if(nx< 0 || nx>=N || ny<0 || ny>=N){
                    ans+=v10;
                }
                else{
                    map[nx][ny]+=v10;
                }
            }
            //map[x+2][y]=v5;

            int n5x=x-2;
            if(n5x<0)
                ans+=v5;
            else{
                map[n5x][y]+=v5;
            }

            int nx=x+dx[direction];
            int nay=y+dy[direction];
            if(0<=nx &&nx<N && 0<=nay && nay<N)
                map[nx][nay]+=a;
            else
                ans+=a;
        }
        //printmap();
        //System.out.println(ans);
    }
    public static void printmap(){
        for(int i=0;i<N;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
