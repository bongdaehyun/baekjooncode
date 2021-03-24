
import java.util.Arrays;
import java.util.PriorityQueue;
public class 프로그래머스_디스크컨트롤러 {

	class Solution {
	    public int solution(int[][] jobs) {
	        Arrays.sort(jobs,(a,b)->a[0]-b[0]);//요청시간이 빠른 순으로 정렬
	        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);//처리시간 정렬
	        int answer=0;
	        int count=0;
	        int jobidx=0;
	        int timeend=0;
	        
	        while(count<jobs.length){
	            //작업중이라 기다려야되는 요청들
	            while(jobidx<jobs.length&&jobs[jobidx][0]<=timeend){
	                pq.add(jobs[jobidx++]);
	            }
	            //작업중이 없다면 요청 처음으로 맞추기
	            if(pq.isEmpty()){
	                timeend=jobs[jobidx][0];
	            }
	            else{
	                int []cnt=pq.poll();
	                answer+=cnt[1]+timeend-cnt[0];
	                timeend+=cnt[1];
	                count++;
	            }
	        }
	        
	        
	        return (int)(answer/jobs.length);
	    }
	}
}
