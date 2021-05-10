import java.util.*;
class Solution {
    static HashMap<String,Integer>map=new HashMap<>();
    static ArrayList<String>combi;
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        combi=new ArrayList<>();
        //문자열을 오름차순 정렬
        for(int i=0;i<orders.length;i++){
            char []arr=orders[i].toCharArray();
            //System.out.println(Arrays.toString(arr));
            Arrays.sort(arr);
            
            
            //코스는 2개이상이므로 마지막은 제외
            for(int j=0;j<arr.length-1;j++){
                //코스 종류에따라 조합생성
                for(int k=0;k<course.length;k++){
                    dfs(arr,j,1,course[k],String.valueOf(arr[j]));
                }
            }
        }
        //조합별 개수 세기
        for(String key:combi){
           map.put(key,map.getOrDefault(key,0)+1);
        }
        ArrayList<String>keylist=new ArrayList<>(map.keySet());
        Collections.sort(keylist,(o1,o2)->(map.get(o2).compareTo(map.get(o1))));

        ArrayList<String>ans=new ArrayList<>();
        for(int j=0;j<course.length;j++){
            int maxv=0;
            for(String key:keylist){
                if(map.get(key)>=2&&key.length()==course[j]){
                    if(map.get(key)>=maxv){
                        ans.add(key);
                        maxv=map.get(key);
                    }
                }
            }
        }
        // for(int i=0;i<ans.size();i++){
        //     System.out.println(ans.get(i));
        // }
        Collections.sort(ans);
        answer=new String[ans.size()];
        ans.toArray(answer);

        return answer;
    }
    static void dfs(char []arr,int start,int len,int course,String str){
        if(len==course){
            combi.add(str);
        }
        
        for(int i=start+1;i<arr.length;i++){
            dfs(arr,i,len+1,course,str+arr[i]);
        }
    }
}