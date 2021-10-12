import jdk.internal.util.xml.impl.Input;

import java.util.*;
import java.io.*;

//모듈러 연산이 핵심(연습해야된다!!!)
public class bj_21610 {
    static int dx[]={0,0,-1,-1,-1,0,1,1,1};
    static int dy[]={0,-1,-1,0,1,1,1,0,-1};
    static int [][]map;
    static boolean visit[][];
    static int n,m;
    public static void main(String[] args)throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        //구름 저장
        ArrayList<cloud>clouds=new ArrayList<>();
        map=new int[n][n];


        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //처음 구름 위치
        clouds.add(new cloud(n-1,0));
        clouds.add(new cloud(n-1,1));
        clouds.add(new cloud(n-2,0));
        clouds.add(new cloud(n-2,1));

        //로직
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int d=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            s%=n;
            //구름 이동
            for(int j=0;j<clouds.size();j++){
                //모둘러 계산
                //System.out.println(clouds.get(j).x+", "+clouds.get(j).y);
//                clouds.get(j).x=mod(clouds.get(j).x+dx[d]*s);
//                clouds.get(j).y=mod(clouds.get(j).y+dy[d]*s);
                clouds.get(j).x=(clouds.get(j).x+dx[d]*s+n)%n;
                clouds.get(j).y=(clouds.get(j).y+dy[d]*s+n)%n;
                map[clouds.get(j).x][clouds.get(j).y]++;
                //System.out.println(clouds.get(j).x+", "+clouds.get(j).y);
            }

            //구름 주변 물 복사
            visit=new boolean[n][n];
            for(cloud c : clouds){
                visit[c.x][c.y]=true;
                int water=0;
                for(int k=2;k<=8;k+=2){
                    int nx=c.x+dx[k];
                    int ny=c.y+dy[k];
                    if(0<=nx && nx<n &&0<=ny&&ny<n &&map[nx][ny]>=1){
                        water++;
                    }
                }
                map[c.x][c.y]+=water;
            }


            //모든 구름 삭제
            clouds.clear();
            //다시 구름 생성
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    if(!visit[a][b] &&map[a][b]>=2){
                        map[a][b]-=2;
                        clouds.add(new cloud(a,b));
                    }
                }
            }

        }
        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer+=map[i][j];
            }
        }
        System.out.println(answer);
    }
    public static int mod(int num){
        while(num<0){
            num+=n;
        }
        return num%n;
    }
    public static void printmap(){
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
    static class cloud{
        int x;
        int y;

        public cloud(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "cloud{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
