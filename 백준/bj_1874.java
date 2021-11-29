import java.util.*;
import java.io.*;

public class bj_1874 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuffer sb=new StringBuffer();
        int n=sc.nextInt();
        Stack<Integer>stack=new Stack<>();
        int []result=new int[n];

        //정답 수열
        for(int i=0;i<n;i++){
            result[i]=sc.nextInt();
        }
        int idx=0;

        for(int i=1;i<=n;i++){
            //System.out.println("i = " + i);
            while(!stack.isEmpty()&&result[idx]==stack.peek()){
                sb.append("- ");
                //System.out.println(stack.pop());
                stack.pop();
                idx++;
            }
            sb.append("+ ");
            stack.push(i);

        }

        while(!stack.isEmpty()&&result[idx]==stack.peek()){
            sb.append("- ");
            stack.pop();
            idx++;
        }
        //System.out.println(idx);
        if(idx==n){
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
        }

    }
}
