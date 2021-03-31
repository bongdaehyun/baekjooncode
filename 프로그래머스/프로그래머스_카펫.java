class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum=brown+yellow;
        
        for(int i=3;i<=sum;i++){
            if(sum%i==0){
                int col=sum/i;
                int row=sum/col;
                
                int a=row-2;
                int b=col-2;
                if(a*b==yellow&&col>=row){
                    answer[0]=col;
                    answer[1]=row;
                    break;
                }
            }
        }
        return answer;
    }
}