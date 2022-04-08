import java.util.*;

//자료구조 , 정렬, 이분탐색
class Solution {

    Map<String,ArrayList<Integer>>map;
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map=new HashMap<>();
        //info로 만들수 있는 모든 경우의 조합 생성
        for(String in:info){
            dfs("",0,in.split(" "));
        }

        //점수들 오름차순으로 정렬
        List<String> list=new ArrayList<>(map.keySet());
        for(int i=0;i<list.size();i++){
            List<Integer>scorelist=map.get(list.get(i));
            // System.out.println("sort 전 "+Arrays.toString(scorelist.toArray()));
            Collections.sort(scorelist);
            // System.out.println("sort 후 "+Arrays.toString(map.get(list.get(i)).toArray()));
        }

        //이진탐색을 이용해서 사람 수 파악
        for(int i=0;i<query.length;i++){
            query[i]=query[i].replace(" and ","");
            String s[]=query[i].split(" ");
            //System.out.println(Arrays.toString(s));
            int score=Integer.parseInt(s[1]);
            answer[i]=search(s[0],score);

        }

        return answer;
    }

    void dfs(String s,int cnt,String []query){

        if(cnt==4){

            if(!map.containsKey(s)){
                ArrayList<Integer>in=new ArrayList<>();
                in.add(Integer.parseInt(query[4]));
                map.put(s,in);
            }else{
                map.get(s).add(Integer.parseInt(query[4]));
            }
            return;
        }


        dfs(s+"-",cnt+1,query);
        dfs(s+query[cnt],cnt+1,query);
    }

    int search(String query,int score){

        if(!map.containsKey(query)) return 0;
        List<Integer>scorelist=map.get(query);
        int left=0;
        int right=scorelist.size()-1;

        while(left <= right){
            int mid=(left+right)/2;

            if(scorelist.get(mid)<score){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }

        return scorelist.size()-left;

    }
}