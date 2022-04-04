import java.util.*;

//균형잡힌 괄호 문자열 : ( ) 개수가 같은 경우
//return 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열
// ( )의 개수는 항상 같다. 이미 올바른괄호문자열이면 변환X 바로 return
class Solution {
    public String solution(String p) {
        String answer = "";


        //올바른 괄호 문자열인지 판단.
        if(isCompleteBk(p)){
            return p;
        }else{
            //변환
            answer=convert(p);
        }

        return answer;
    }

    public boolean isCompleteBk(String s){
        char []c=s.toCharArray();
        //System.out.println(Arrays.toString(c));
        Deque<Character>stack=new ArrayDeque<>();

        for(char sc : c){
            if(sc=='('){
                stack.add(sc);
            }else if(!stack.isEmpty()&&sc==')'&&stack.peek()=='('){
                stack.pop();
            }else{
                //System.out.println(sc);
                return false;
            }

        }

        return true;
    }

    public String convert(String s){
        char []c=s.toCharArray();
        String result="";
        StringBuilder u_sb=new StringBuilder();
        StringBuilder v_sb=new StringBuilder();
        int left=0,right=0;

        //입력이 빈 문자열인 경우
        if(s.equals("")){
            return "";
        }

        for(int i=0;i<c.length;i++){
            if(c[i]=='(') {
                u_sb.append(c[i]);
                left++;
            }
            else {
                u_sb.append(c[i]);
                right++;
            }
            //문자열 u,v 분리
            if(left==right){
                for(int j=i+1;j<c.length;j++){
                    v_sb.append(c[j]);
                }

                //u가 올바른 괄호 문자열인지 판단
                if(isCompleteBk(u_sb.toString()))
                {
                    u_sb.append(convert(v_sb.toString()));
                }else{
                    StringBuilder sb=new StringBuilder("(");
                    sb.append(convert(v_sb.toString()));
                    sb.append(")");

                    u_sb.deleteCharAt(0);
                    u_sb.deleteCharAt(u_sb.length()-1);
                    //괄호 방향 반대로
                    char []uc=u_sb.toString().toCharArray();
                    for(char ucc:uc){
                        if(ucc=='(') sb.append(')');
                        else sb.append('(');
                    }

                    return sb.toString();
                }
                //v 재귀 후 반환하기 위함
                break;
            }
        }

        return u_sb.toString();
    }
}