package samsung.src;

import java.util.*;
import java.io.*;


public class bj_20058 {
    static int map[][];
    static int n, q, N,maxIce;
    //시계방향
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = stoi(st.nextToken());
        q = stoi(st.nextToken());
        N = (int) Math.pow(2, n);
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        for(int i=0;i<q;i++){
            int L = stoi(st.nextToken());
            doDivide(L);
            doIceMelt();
        }

        //System.out.println(mapSum());
        System.out.println(doMaxIce());
        System.out.println(maxIce);
    }

    private static void doDivide(int L){
        int size = 1<<L;

        int [][]copy = new int[N][N];

        for(int i=0;i<N;i+=size){
            for(int j=0;j<N;j+=size){
                for(int a=0;a<size;a++){
                    for(int b=0;b<size;b++){
                        copy[i+a][j+b] = map[i+size-b-1][a+j];
                    }
                }
            }
        }
        map = copyMap(copy);
    }

    //회전시키면서 너무많은 배열복사로 해서 시간초과에 걸렸다.
    private static void rotate(int x, int y, int size){
        int [][]copy = copyMap(map);

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                copy[x+i][y+j] = map[x+size-j-1][y+i];
            }
        }

        map = copyMap(copy);
    }

    private static void printmap(int [][]list){
        for(int i=0;i<N;i++) {
            System.out.println(Arrays.toString(list[i]));
        }
        System.out.println();
    }

    private static int doMaxIce(){

        boolean visit[][] = new boolean[N][N];
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum+=map[i][j];
                if(map[i][j]==0 || visit[i][j])continue;
                int count=1;
                Deque<int []>q = new ArrayDeque<>();
                q.add(new int[]{i,j});
                visit[i][j]=true;

                while(!q.isEmpty()){
                    int cnt[] = q.poll();

                    for(int k=0;k<4;k++){
                        int nx = cnt[0]+dx[k];
                        int ny = cnt[1]+dy[k];

                        if(0<=nx && nx<N && 0<=ny && ny<N && !visit[nx][ny]){
                            if(map[nx][ny]>0){
                                count++;
                                visit[nx][ny]=true;
                                q.add(new int[]{nx,ny});
                            }
                        }
                    }
                }

                maxIce = Math.max(maxIce,count);
            }
        }

        return sum;
    }

    private static int mapSum(){
        int result = 0;
        for(int i=0;i<N;i++){

            for(int j=0;j<N;j++){
               result += map[i][j];
            }
        }
        return result;
    }

    private static void doIceMelt(){
        ArrayList<int []> temp = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int count=0;
                if(map[i][j]==0)continue;

                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(0<=nx && nx<N && 0<=ny && ny<N){
                        if(map[nx][ny]>0){
                            count++;
                        }
                    }
                }

                if(count < 3){
                    temp.add(new int[]{i,j});
                }
            }
        }

        for(int []t : temp){
            map[t[0]][t[1]]--;
        }
    }

    private static int[][] copyMap(int [][]list){
        int [][]copy = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                copy[i][j]=list[i][j];
            }
        }

        return copy;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
