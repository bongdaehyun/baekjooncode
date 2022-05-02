
import java.util.*;
public class pg_빛의경로사이클_lv2 {

    int R,C;
    boolean visited[][][];
    int dx[] = {1,0,-1,0};
    int dy[] = {0,-1,0,1};
    public int[] solution(String[] grid) {

        R = grid.length;
        C = grid[0].length();
        //4방향 체크
        visited = new boolean [R][C][4];
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                for(int d =0; d<4; d++){
                    if(visited[i][j][d])continue;
                    answer.add(process(i,j,d,grid));
                }

            }
        }

        return answer.stream().sorted().mapToInt(x->x).toArray();
    }

    private int process(int x,int y,int d,String []grid){
        int cnt =0;

        while(true){

            if(visited[x][y][d])break;
            cnt++;
            visited[x][y][d]=true;

            //좌회전
            if(grid[x].charAt(y) == 'L'){
                d = (d+3)%4;
            }else if(grid[x].charAt(y) == 'R'){//우회전
                d = (d+1)%4;
            }

            x = (x + dx[d] + R) % R;
            y = (y + dy[d] + C) % C;
        }

        return cnt;
    }

}
