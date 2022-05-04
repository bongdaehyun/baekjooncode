import java.util.*;
public class pg_추석트래픽_lv3 {

    class Solution {
        public int solution(String[] lines) {
            int answer = 0;

            Datetime datetime[] = new Datetime[lines.length];

            for(int i=0;i<lines.length;i++){
                lines[i] = lines[i].substring(11,lines[i].length()-1);
                //밀리초로 변경
                String s[] = lines[i].split(" ");
                String date[] = s[0].split(":");

                int hh = Integer.parseInt(date[0])*3600*1000;
                int mm = Integer.parseInt(date[1])*60*1000;
                double ss = Double.parseDouble(date[2])*1000;
                double space = Double.parseDouble(s[1])*1000;

                int end = hh+mm+(int)ss;
                int start = end -(int)space +1;
                datetime[i] = new Datetime(start,end);
            }

            //트래픽 개수의 변화가 이루어지는 곳을 검사
            for(int i=0;i<lines.length;i++){ //기준
                int cnt =0;

                //시작 시간 ~ 시작 시간 + 1초
                cnt = getCount(datetime,lines.length,datetime[i].start,datetime[i].start+1000,i);
                answer = Math.max(cnt,answer);
                //응답 시간 ~ 응답 시간 + 1초
                cnt = getCount(datetime,lines.length,datetime[i].end,datetime[i].end+1000,i);
                answer = Math.max(cnt,answer);
            }

            return answer;
        }

        private int getCount(Datetime []datetime,int length, int start,int startPlus, int i){
            int count = 0;

            for(int j=i;j<length;j++){
                if((datetime[j].start <= start && startPlus <= datetime[j].end)
                        || (start <= datetime[j].start && datetime[j].start < startPlus)
                        || (start <= datetime[j].end && datetime[j].end < startPlus)
                ){
                    count++;
                }

            }

            return count;
        }
        class Datetime{
            int start;
            int end;

            public Datetime(int start,int end){
                this.start = start;
                this.end = end;
            }
        }
    }
}
