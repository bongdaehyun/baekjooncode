import java.util.*;

class Solution {
    //시간대별의 오룸차순을 위해 우선순위 큐를 이용
    //09:00 시간을 모두 분으로 변환하여 비교 및 계산
    //String.format을 이용하여 분을 시간으로 변환

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(String time : timetable){
            int timeTomin = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3));
            pq.add(timeTomin);
        }

        int startTime = 9*60;
        int lastTime = 0;
        int total = 0;
        int currentTime = 0;

        for(int i=0;i<n;i++){
            total = 0;
            while(!pq.isEmpty()){
                currentTime = pq.peek();
                if(total < m && currentTime <= startTime){
                    pq.poll();
                    total++;
                    lastTime = currentTime-1;
                }else{
                    break;
                }
            }
            startTime += t;
        }

        if(total < m)
            lastTime = startTime -t;

        String hour = String.format("%02d",lastTime/60);
        String min = String.format("%02d",lastTime%60);
        answer= hour+":"+min;
        return answer;
    }
}