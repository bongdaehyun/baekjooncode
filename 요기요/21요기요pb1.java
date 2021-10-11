//Stack 문제
import java.util.*;

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Integer> stack=new Stack<>();
        String [] s=S.split(" ");
       
        for(int i=0;i<s.length;i++){
            
            if(s[i].equals("DUP")){
                int newVal=stack.peek();
                
                stack.push(newVal);
            }else if(s[i].equals("POP")){
                stack.pop();
            }else if(s[i].equals("-")){
                if(stack.size()<2){
                    return -1;
                }
                int v1=stack.pop();
                int v2=stack.pop();
                stack.push(v1-v2);
            }else if(s[i].equals("+")){
                if(stack.size()<2){
                    return -1;
                }
                int v1=stack.pop();
                int v2=stack.pop();
                stack.push(v1+v2);
            }
            else{ 
                stack.push(Integer.parseInt(s[i]));
            }
        }
        return stack.peek();
    }
}
