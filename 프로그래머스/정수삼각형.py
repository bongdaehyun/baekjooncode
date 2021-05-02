import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int dp[][]=new int[triangle.length][];
        for(int i=0;i<triangle.length;i++)
            dp[i]=triangle[i].clone();
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){
                    dp[i][j]=dp[i-1][j]+triangle[i][j];
                }else if(j==triangle[i].length-1){
                    dp[i][j]=dp[i-1][j-1]+triangle[i][j];
                }
                else{
                    int a=dp[i-1][j-1]+triangle[i][j];
                    int b=dp[i-1][j]+triangle[i][j];
                    dp[i][j]=Math.max(a,b);
                }
            }
        }
        for(int i=0;i<triangle[triangle.length-1].length;i++){
            answer=Math.max(answer,dp[triangle.length-1][i]);   
        }
        //System.out.print(Arrays.toString(dp[triangle.length-1]));
        return answer;
    }
}