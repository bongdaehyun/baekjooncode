import java.util.*;

public class pg_보석쇼핑_lv3 {


    Set<String> gemSet = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] gems) {
        int[] answer = {};
        for (String g : gems) {
            gemSet.add(g);
        }

        int start = 0; //시작 범위
        int tempS = 0; //임시 시작범위 설정
        int len = gems.length; //길이
        Deque<String> q = new ArrayDeque<>();

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);

            q.offer(gem);
            //System.out.println(q);

            //중복된 보석이 있는지
            while (true) {
                String s = q.peek();

                if (map.get(s) > 1) {
                    tempS++;
                    q.poll();
                    map.put(s, map.get(s) - 1);
                } else break;

            }

            //System.out.println("중복제거"+q);
            //모든 종류의 보석을 가지고 있다.
            if (map.size() == gemSet.size()) {
                if (len > q.size()) {
                    len = q.size();
                    start = tempS;
                }
            }

        }

        return new int[]{start + 1, start + len};
    }

}
