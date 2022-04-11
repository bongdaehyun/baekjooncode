import java.util.*;

class Solution {
    final int num = 65536;

    public int solution(String str1, String str2) {
        int answer = 0;

        //다중집합으로 만들기
        List<String> strlist1 = multiset(str1);
        List<String> strlist2 = multiset(str2);


        if(strlist1.isEmpty() && strlist2.isEmpty()){
            answer=1*num;
        }else{
            HashMap<String, Integer> countNum1 = countNum(strlist1);
            HashMap<String, Integer> countNum2 = countNum(strlist2);

            //System.out.println(countNum1);
            //System.out.println(countNum2);

            double interSet = 0.0;
            double sumSet = 0.0;

            for(String key : countNum1.keySet()){
                //System.out.println(key);
                if(countNum2.containsKey(key)){
                    interSet += (double)Math.min(countNum1.get(key),countNum2.get(key));
                    sumSet += (double)Math.max(countNum1.get(key),countNum2.get(key));
                }else{
                    sumSet += countNum1.get(key);
                }
            }
            for(String key : countNum2.keySet()){
                if(!countNum1.containsKey(key))
                    sumSet += countNum2.get(key);
            }

            //System.out.println(interSet+","+sumSet);

            answer = (int)((interSet/sumSet)*num);

        }


        return answer;
    }
    private HashMap<String,Integer> countNum(List<String> list){
        HashMap<String, Integer> count = new HashMap<>();

        for(String s : list){
            count.put(s,count.getOrDefault(s,0)+1);
        }
        return count;
    }

    private List<String> multiset(String str){
        char s[] = str.toLowerCase().toCharArray();
        List<String> list = new ArrayList<>();

        for(int i=0;i<s.length-1;i++){
            if(97 <= s[i]  && s[i] <=122 && 97 <= s[i+1] && s[i+1] <= 122)
                list.add(Character.toString(s[i])+Character.toString(s[i+1]));
        }
        return list;
    }
}