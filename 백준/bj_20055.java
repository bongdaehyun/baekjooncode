import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_20055 {
    static int n,k,time;
    static int []belt,robots;
    public static void main(String[] args)throws Exception {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        belt=new int[2*n];
        robots=new int[2*n];
        String []s=in.readLine().split(" ");
        for(int i=0;i<2*n;i++)
            belt[i]=Integer.parseInt(s[i]);


        while(true){
            if(countzero()>=k)
                break;
            //로봇과 벨트 이동
            rotate();
            //내려가는 위치
            if(robots[n-1]!=0)
                robots[n-1]=0;
            //로봇 이동
            for(int i=n-2;i>=0;i--){
                if(robots[i]==1&&robots[i+1]==0&&belt[i+1]>=1){
                    robots[i+1]=robots[i];
                    robots[i]=0;
                    belt[i+1]--;
                }
            }

            //내려가는 위치
            if(robots[n-1]!=0)
                robots[n-1]=0;
            //로봇올리기
            if(belt[0]>=1){
                robots[0]=1;
                belt[0]--;
            }
            time++;
        }
        System.out.println(time);
    }
    public static void rotate(){
        int temp=belt[2*n-1];
        for(int i=2*n-2;i>=0;i--){
            belt[i+1]=belt[i];
        }
        belt[0]=temp;

        int temp1=robots[2*n-1];
        for(int i=2*n-2;i>=0;i--){
            robots[i+1]=robots[i];
        }
        robots[0]=temp1;

    }
    public static int countzero(){
        int count=0;

        for(int i=0;i<2*n;i++){
            if(belt[i]==0)
                count++;
        }
        return count;
    }
}
