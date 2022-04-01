import java.util.*;
//과녁을 많이 맞춘 사람이 점수 가져감
//어피치 == 라이언 : 어피치  승

//return 라이언이 가장 큰 점수차이로 우승하기 위한 과녁의 경우는?, 단 비기거나 지는 경우 -1 -> 완전탐색
public class programmers_양궁대회 {
    int []lion;
    int[] answer;
    int maxV;
    final int size = 11;
    //화살의 개수 ,어피치가 맞힌 과녁의 점수의 개수 정보
    public int[] solution(int n, int[] info) {
        answer= new int[]{-1};

        lion = new int[size];
        maxV = Integer.MIN_VALUE;
        dfs(0,n,info);
        //System.out.println(Arrays.toString(lion));
        return answer;
    }

    public void dfs(int cnt, int end, int[] info){

        //화살의 개수 break
        if(cnt==end){
            //점수 계산
            int lion_point=0;
            int apeach_point=0;

            for(int i=0;i<11;i++){
                if(info[i] ==0 && lion[i]==0) continue;
                if(info[i]<lion[i]){
                    lion_point+=10-i;
                }else{
                    apeach_point+=10-i;
                }
            }

            if(apeach_point>=lion_point) return ;

            if(maxV<=lion_point-apeach_point){
                answer=lion.clone();
                maxV=lion_point-apeach_point;
            }


            return ;
        }

        //화살의 개수를 정하는 반복문
        //어피치로 부터 라이언이 점수를 딸 때 까지 반복
        for(int i=0;i<size&&lion[i]<=info[i];i++){

            lion[i]++;
            dfs(cnt+1,end,info);
            lion[i]--;

        }
    }
}
