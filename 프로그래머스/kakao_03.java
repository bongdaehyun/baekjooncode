import java.util.*;

class Solution {
    public int[] solution(int n, int[] passenger, int[][] train) {
       
        boolean []visited=new boolean[n+1];
        ArrayList<Integer> []dolist=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            dolist[i]=new ArrayList<>();
        
        for(int i=0;i<n-1;i++){
           dolist[train[i][0]].add(train[i][1]);
            dolist[train[i][1]].add(train[i][0]);
        }
        ArrayDeque<int []>q=new ArrayDeque<>();
        visited[1]=true;
        q.add(new int[]{1,passenger[0]});
        int maxv=0;
        int idx=0;
        while(!q.isEmpty()){
            int []cnt=q.poll();
            if(maxv<cnt[1]){
                maxv=cnt[1];
                idx=cnt[0];
            }
            if(maxv==cnt[1]&&idx<cnt[0]){
                idx=cnt[0];
            }
            for(int to:dolist[cnt[0]]){
                if(visited[to])continue;
                visited[to]=true;
                q.add(new int[]{to,cnt[1]+passenger[to-1]});
            }
            
        }
        
        
        
        return new int[]{idx,maxv};
    }
    
}