import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String ns = s;
        for(int i=0;i<s.length();i++){
            if(i!=0)
                ns=ismove(ns);
            if(isComplete(ns)){
                answer++;
            }
            
        }
        return answer;
    }
    private String ismove(String ns){
        char c[] = ns.toCharArray();
        char temp = c[0];
        for(int i=1;i<c.length;i++){
            c[i-1] = c[i];
        }
        c[c.length-1] = temp;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<c.length;i++){
            sb.append(c[i]);
        }
        return sb.toString();
    }
    private boolean isComplete(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            
            char c =s.charAt(i);
            
            if(c == '[' || c == '{' || c == '('){
                stack.add(c);
            }else if(!stack.isEmpty()&&stack.peek() == '[' && c == ']'){
                stack.pop();
            }else if(!stack.isEmpty()&&stack.peek() == '(' && c == ')'){
                stack.pop();
            }else if(!stack.isEmpty()&&stack.peek() == '{' && c == '}'){
                stack.pop();
            }
            else{
                stack.add(c);
            }
            
        }
        
        return stack.isEmpty() ? true : false;
    }
}