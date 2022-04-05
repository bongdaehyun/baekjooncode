import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2503_숫자야구 {

    static ArrayList<BallData> ballList=new ArrayList<>();
    static int res;
    static boolean isSel[];

    public static void main(String[] args) throws Exception {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        int n=stoi(in.readLine());
        isSel=new boolean[10];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            String data=st.nextToken();
            int strike=stoi(st.nextToken());
            int ball=stoi(st.nextToken());

            ballList.add(new BallData(data,strike,ball));
        }

        dfs(0,3,new StringBuilder());
        System.out.println(res);
    }
    //세자리 숫자 생성하여
    public static void dfs(int cnt,int end,StringBuilder num){

        if(cnt==end){
            //System.out.println(num.toString());
            String gernete_num=num.toString();
            boolean flag=false;
            for(int j=0;j<ballList.size();j++){
                int st_n=0,ball_n=0;

                //strike 체크
                for(int a=0;a<3;a++){
                    if(gernete_num.charAt(a)==ballList.get(j).data.charAt(a)){
                        st_n++;
                    }
                }
                //ball 체크
                for(int a=0;a<3;a++){
                    if(gernete_num.charAt(a)!=ballList.get(j).data.charAt(a)){

                        for(int b=0;b<3;b++){
                            if(a==b)continue;
                            if(gernete_num.charAt(a)==ballList.get(j).data.charAt(b)){
                                ball_n++;
                            }
                        }
                    }
                }
                //System.out.println(j+"번쪠"+st_n+","+ball_n);

                if(st_n!=ballList.get(j).strike || ball_n!=ballList.get(j).ball){
                    return;
                }
            }

            res++;
            return ;
        }

        for(int i=1;i<=9;i++){
            if(isSel[i])continue;
            isSel[i]=true;
            num.append(i);
            dfs(cnt+1,end,num);
            num.deleteCharAt(num.length()-1);
            isSel[i]=false;
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

    static class BallData{
        String data;
        int strike;
        int ball;

        public BallData(String data,int strike,int ball){
            this.data=data;
            this.strike=strike;
            this.ball=ball;
        }
    }
}
