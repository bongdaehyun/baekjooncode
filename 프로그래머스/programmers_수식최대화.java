import java.util.*;

public class programmers_수식최대화 {
    final char []prior = {'*','+','-'};
    ArrayList<Character> opslists = new ArrayList<>();
    ArrayList<Long> numlists = new ArrayList<>();
    boolean check[] = new boolean[3];
    char []pick = new char[3];
    long answer = 0;

    public long solution(String expression) {

        char []c = expression.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char nc : c){
            if('0' <= nc && nc <= '9')
            {
                sb.append(nc);
            }else{
                numlists.add(Long.parseLong(sb.toString().trim()));
                sb = new StringBuilder();
                opslists.add(nc);
            }
        }
        numlists.add(Long.parseLong(sb.toString()));
        System.out.println(opslists+","+numlists+","+answer);
        dfs(0);
        return answer;
    }

    private void dfs(int cnt){
        if(cnt == 3 ){

            ArrayList<Character> ops = new ArrayList<>(opslists);
            ArrayList<Long> num = new ArrayList<>(numlists);

            for(int i=0;i<pick.length;i++){
                for(int j=0;j<ops.size();j++){
                    if(pick[i] == ops.get(j)){
                        long n = calnum(num.remove(j),num.remove(j),pick[i]);
                        num.add(j,n);
                        ops.remove(j);
                        j--;
                    }
                }
            }
            //System.out.println(Arrays.toString(pick)+","+num.get(0));
            answer = Math.max(answer,Math.abs(num.get(0)));
            return;
        }

        //우선순위 정하기
        for(int i=0;i<3;i++){
            if(check[i])continue;
            check[i]=true;
            pick[cnt]=prior[i];
            dfs(cnt+1);
            check[i]=false;
        }
    }

    private long calnum(long a,long b,char c){
        if(c == '*'){
            return a*b;
        }else if(c == '+'){
            return a+b;
        }else
            return a-b;
    }
}
