import java.util.*;

class Solution {
    static int []pick;
    static int maxv;
    public int solution(int[][] needs, int r) {
        pick=new int[r];
        combi(0,0,r,needs);
        
        return maxv;
    }
    
    public static void combi(int cnt,int start,int r,int [][]needs){
        if(cnt==r){
            //System.out.println(Arrays.toString(pick));
            int copy[][]=new int[needs.length][needs[0].length];
            for(int i=0;i<needs.length;i++){
                for(int j=0;j<needs[0].length;j++){
                    copy[i][j]=needs[i][j];
                }
            }
            int ans=0;
            for(int i=0;i<needs.length;i++){
                boolean flag=true;
                for(int p=0;p<pick.length;p++)
                {
                    copy[i][pick[p]]=0;
                }
                for(int j=0;j<needs[0].length;j++){
                    if(copy[i][j]==1){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    ans++;
                
            }
            maxv=Math.max(ans,maxv);
            return;
        }
        
        for(int i=start;i<needs[0].length;i++){
            pick[cnt]=i;
            combi(cnt+1,i+1,r,needs);
        }
    }
    
}