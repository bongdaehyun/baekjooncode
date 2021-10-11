// 그래프의 사이클이 있는지 확인

import java.util.*;

class Solution {
    boolean visit[];
    int []arr;
    boolean answer;
    public void dfs(int node){
        visit[node]=true;

        int next=arr[node];
        if(!visit[next]){
            dfs(next);
        }
        
    }
    public boolean solution(int[] A, int[] B) {
        answer=false;
        int n=A.length;
        arr=new int[n+1];

        for(int i=0;i<n;i++){
            arr[A[i]]=B[i];
        }
        visit=new boolean[n+1];
        dfs(1);
        for(int i=1;i<=n;i++){
            if(!visit[i]){
                answer=true;
                break;
            }
        }

        return answer;
    }
}
