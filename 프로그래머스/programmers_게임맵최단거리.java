import java.util.*;


public class programmers_게임맵최단거리 {
    static int []dx={0,1,0,-1};
    static int []dy={1,0,-1,0};

    public static int solution(int[][] maps) {
        int answer = -1;
        int n=maps.length;
        int m=maps[0].length;


        boolean visit[][]=new boolean[n][m];
        Deque<int []>q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        visit[0][0]=true;
        boolean check=false;

        while(!q.isEmpty()){
            int cnt[]=q.poll();

            if(cnt[0]==n-1 && cnt[1]==m-1){
                check=true;
                answer=cnt[2];
                break;
            }

            for(int k=0;k<4;k++){
                int nx=cnt[0]+dx[k];
                int ny=cnt[1]+dy[k];

                if(0<=nx && nx<n && 0<=ny && ny<m && !visit[nx][ny]){
                    if(maps[nx][ny]==1){
                        visit[nx][ny]=true;
                        q.offer(new int[]{nx,ny,cnt[2]+1});
                    }
                }
            }

        }


        return answer;
    }
}

