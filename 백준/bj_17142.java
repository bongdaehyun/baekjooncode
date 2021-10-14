import java.util.*;
import java.io.*;

public class bj_17142 {
    static int map[][];
    static int n,m,ans,binv;
    static ArrayList<int []>virus;
    static int []pick;
    static int dx[]={0,1,-1,0};
    static int dy[]={1,0,0,-1};

    public static void main(String[] args)throws Exception {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=stoi(st.nextToken());
        m=stoi(st.nextToken());
        map=new int[n][n];
        pick=new int[m];
        virus=new ArrayList<>();
        ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=stoi(st.nextToken());
                if(map[i][j]==2){
                    virus.add(new int[]{i,j});
                }else if(map[i][j]==0){
                    binv++;
                }
            }
        }
        //System.out.println(virus.size());
        if(binv==0){
            System.out.println(0);
        }else{
            dfs(0,0);
            System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }

    }

    public static void dfs(int start,int cnt){

        if(cnt==m){
            //System.out.println(Arrays.toString(pick));
            boolean visited[][]=new boolean[n][n];
            Deque<int []>q=new ArrayDeque<>();
            int emptyspace=binv;
            for(int i=0;i<pick.length;i++){
                int [] v= virus.get(pick[i]);
                q.add(v);
                visited[v[0]][v[1]]=true;
            }

            int time=1;

            while(!q.isEmpty()){
                int qlen=q.size();
                while(qlen-->0){
                    int c[]=q.pollFirst();
                    for(int k=0;k<4;k++){
                        int nx=c[0]+dx[k];
                        int ny=c[1]+dy[k];

                        if(0<=nx&&nx<n&&0<=ny&&ny<n && !visited[nx][ny]){
                            //빈칸 and 비활성 바이러스
                            if(map[nx][ny]==1) continue;
                            if(map[nx][ny]==0){
                                emptyspace--;
                            }
                            if(emptyspace==0){
                                ans=Math.min(time,ans);
                                return;
                            }

                            visited[nx][ny]=true;
                            q.add(new int[]{nx,ny});

                        }
                    }
                }
                time++;
            }
            return;
        }
        //활성화 바이러스 선택 -조합이 제대로 안된다.-
        for(int i=start;i<virus.size();i++){

            pick[cnt]=i;
            dfs(i+1,cnt+1);

        }
    }
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
}
