import java.util.*;

public class programmers_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //Setting
        HashSet<String> list=new HashSet<>();
        for(int i=0;i<report.length;i++){
            list.add(report[i]);
        }

        Map<String,Integer> id_check=new HashMap<>();
        Map<String,ArrayList<String>> reportId=new HashMap<>();

        for(int i=0;i<id_list.length;i++){
            id_check.put(id_list[i],0);
        }
        Iterator iter = list.iterator();	// Iterator 사용
        while(iter.hasNext()) {//값이 있으면 true 없으면 false
            String rpt[]=((String)iter.next()).split(" ");

            if(id_check.containsKey(rpt[1])){
                id_check.put(rpt[1],id_check.get(rpt[1])+1);
            }else{
                id_check.put(rpt[1],1);
            }
            if(reportId.containsKey(rpt[0])){
                 ArrayList<String>tempList=reportId.get(rpt[0]);
                 tempList.add(rpt[1]);
                reportId.put(rpt[0],tempList);
            }else{
                ArrayList<String>tempList=new ArrayList<>();
                tempList.add(rpt[1]);
                reportId.put(rpt[0],tempList);
            }

        }


        for(int i=0;i<id_list.length;i++){
            int count=0;

            ArrayList<String>checkList =reportId.get(id_list[i]);
            if(checkList!=null){
                for(String id:checkList){
                    if(id_check.get(id)>=k){
                        count++;
                    }
                }
            }
            answer[i]=count;
        }

        return answer;
    }
}
