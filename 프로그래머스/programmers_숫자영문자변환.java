import java.util.*;
public class programmers_숫자영문자변환 {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, Integer> EngToNum = new HashMap<>();
        EngToNum.put("zero", 0);
        EngToNum.put("one", 1);
        EngToNum.put("two", 2);
        EngToNum.put("three", 3);
        EngToNum.put("four", 4);
        EngToNum.put("five", 5);
        EngToNum.put("six", 6);
        EngToNum.put("seven", 7);
        EngToNum.put("eight", 8);
        EngToNum.put("nine", 9);

        StringBuffer sb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        char nC[] = s.toCharArray();

        for (char c : nC) {
            if (97 <= c && c <= 122) {
                sb.append(c);
            } else {
                result.append(c);
            }

            if (EngToNum.containsKey(sb.toString())) {
                result.append(EngToNum.get(sb.toString()));
                sb.setLength(0);
            }
        }

        return Integer.parseInt(result.toString());

        /* replaceAll를 이용한 풀이
         String al[]=new String[]{"zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        };
        String num[]=new String[]{"0","1","2","3","4","5","6","7","8","9"};
        for(int i=0;i<10;i++){
            s=s.replaceAll(al[i],num[i]);
        }
        return Integer.parseInt(s);
         */
    }
}
