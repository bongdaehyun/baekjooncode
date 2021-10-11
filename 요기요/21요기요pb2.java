//bfs문제
import java.util.*;

class Solution {
    public int[] solution(String[] B) {
        // write your code in Java SE 8
        String [][] board=new String[B.length][];
        int [] answer=new int[3];
        int[]dx= {0,1,0,-1};
	    int[]dy= {1,0,-1,0};

        
        for(int i=0;i<B.length;i++){
            board[i]=B[i].split("");
        }
        ArrayDeque<int []>q=new ArrayDeque<>();
        boolean [][]visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j].equals("#") && !visited[i][j]){
                    int size=1;
                    visited[i][j]=true;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int cnt[]=q.pollFirst();
                        for(int k=0;k<4;k++) {
                            int nx=cnt[0]+dx[k];
                            int ny=cnt[1]+dy[k];
                            if(0<=nx&&nx<board.length&&0<=ny&&ny<board[i].length&&!visited[nx][ny]) {
                                if(board[nx][ny].equals("#")){
                                    size++;
                                    q.add(new int[]{nx,ny});
                                    visited[nx][ny]=true;
                                }
                            }
                        }
                    }
                    
                    if(size==1){
                        answer[0]++;
                    }else if(size==2){
                        answer[1]++;
                    }else{
                        answer[2]++;
                    }
                }
            }
        }

        return answer;
    }
}
