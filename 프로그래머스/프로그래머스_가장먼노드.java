
import java.util.ArrayDeque;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean check[][]=new boolean[n+1][n+1];
        boolean visited[]=new boolean[n+1];
        
        for(int i=0;i<edge.length;i++){
            int from=edge[i][0];
            int to=edge[i][1];
            check[from][to]=check[to][from]=true;
        }
        int d[]=new int[n+1];
        ArrayDeque<Integer>q=new ArrayDeque<>();
        q.offer(1);
        visited[1]=true;
        int max=d[0];
        while(!q.isEmpty()){
             int cnt=q.poll();
             for(int i=1;i<=n;i++){
                 if(!visited[i]&&check[cnt][i]){
                     d[i]=d[cnt]+1;
                     visited[i]=true;
                     q.offer(i);
                     max=Math.max(max,d[i]);
                 }
             }
        }
        
       //ystem.out.println(Arrays.toString(d));
        //stem.out.println(max);

        for(int i=1;i<=n;i++){
            if(max==d[i])
                answer++;
        }
        return answer;
    }
}
