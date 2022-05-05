import java.util.*;


/*
방법 : 순열로 후보키의 종류를 만들어서 성질에 맞는지 판단
1~N개

Collections.containsAll() : 해당 Collections의 모든 원소를 포함하고 있다면 true
*/
class Solution {
    int picks[];
    int ans = 0;
    List<ArrayList<Integer>> candi = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        picks = new int[relation[0].length];
        int attribute_len = relation[0].length;
        
        for(int i=1;i<=attribute_len;i++){
            dfs(0,i,attribute_len,0,relation);    
        }
        
        return candi.size();
    }
    
    private void dfs(int cnt,int end,int length,int start,String[][] relation){
        if(cnt == end){
            
            Map<String,Integer> map = new HashMap<>();
            ArrayList<Integer> list =new ArrayList<>();
            //유일성 여부 판단
            for(int i=0;i<relation.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int p =0 ;p<end;p++){
                    sb.append(relation[i][picks[p]]);
                }
                
                if(map.containsKey(sb.toString())){
                    return;
                }else{
                    map.put(sb.toString(),1);
                }
            }
            //후보 등록
            for(int i=0;i<end;i++){
                list.add(picks[i]);
            }
            
            //최소성 여부 판단
            for(ArrayList<Integer> temp : candi){
                if(list.containsAll(temp)){
                    return;
                }
            }
            
            candi.add(list);
            return;
        }
        
        
        for(int i=start;i<length;i++){
            picks[cnt] = i;
            dfs(cnt+1,end,length,i+1,relation);
        }
    }
    
    
}