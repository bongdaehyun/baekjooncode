import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class bj_21608 {
    static int classroom[][];
    static int dx[]={0,1,-1,0};
    static int dy[]={1,0,0,-1};

    static int n;
    public static void main(String[] args)throws Exception {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        n=stoi(in.readLine());
        classroom=new int[n][n];
        StringTokenizer st;
        int size=n*n;

        ArrayList<Set<Integer>> students=new ArrayList<>();
        for(int i=0;i<=size;i++){
            students.add(new HashSet<>());
        }

        int order[]=new int[size];
        for(int i=0;i<size;i++){
            st=new StringTokenizer(in.readLine());
            int idx=stoi(st.nextToken());
            for(int j=0;j<4;j++)
                students.get(idx).add(stoi(st.nextToken()));
            order[i]=idx;
        }
        PriorityQueue<int []>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a=o1[0]-o2[0];
                if(a==0){
                    return o1[1]-o2[1];
                }
                return a;
            }
        });


        for(int i=0;i<size;i++){
            //System.out.println("order[i] = " + order[i]);
            pq.clear();
            //처음
            if(i==0){
                classroom[1][1]=order[i];
                continue;
            }
            //printmap();
            //조건

            int manyp=-1;
            //인접한 칸에 좋아하는 학생의 경우
            ArrayList<int []>list=new ArrayList<>();
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){

                    //System.out.println(x+" = " +y );
                    //비어있는 칸
                    if(classroom[x][y]==0){
                        int count=0;
                        int binc=0;
                        //인접한 칸
                        for(int k=0;k<4;k++){
                            int nx=x+dx[k];
                            int ny=y+dy[k];
                            if(0<=nx&&nx<n&&0<=ny&&ny<n&&students.get(order[i]).contains(classroom[nx][ny])){
                                count++;
                            }
                            //비어있는 칸
                            else if(0<=nx&&nx<n&&0<=ny&&ny<n&& classroom[nx][ny]==0){
                                binc++;
                            }
                        }
                        //System.out.println("count"+count+" "+manyp);
                        if(manyp < count){
                            list.clear();
                            manyp=count;
                            list.add(new int[]{x,y,binc});
                        }else if(manyp==count){
                            list.add(new int[]{x,y,binc});
                        }
                        //System.out.println(list.size());
                    }
                    
                }
            }
//            for(int []t:list){
//                System.out.print(Arrays.toString(t));
//            }
//            System.out.println();

            if(list.size()==1){

                //System.out.println("1번 조건 "+list.get(0)[0]+" "+list.get(0)[1]);
                classroom[list.get(0)[0]][list.get(0)[1]]=order[i];
            }else{
                //System.out.println("Arrays.toString(list.get(0)) = " +list.size()+","+ Arrays.toString(list.get(0)));
                int tempv=list.get(0)[2];
                pq.add(list.get(0));
                for(int a=1;a<list.size();a++){
                    if(tempv<list.get(a)[2]){
                        pq.clear();
                        tempv=list.get(a)[2];
                        pq.add(list.get(a));
                    }
                    else if(tempv==list.get(a)[2]){
                        pq.add(list.get(a));
                    }
                }
            }
            //System.out.println(pq.size());
            if(!pq.isEmpty()){
                int []cnt=pq.poll();
                //System.out.println("Arrays.toString(cnt) = " + Arrays.toString(cnt));
                classroom[cnt[0]][cnt[1]]=order[i];
                
            }
        }
        //printmap();
        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int count=0;
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];

                    if(0<=nx&&nx<n&&0<=ny&&ny<n&&students.get(classroom[i][j]).contains(classroom[nx][ny])){
                        count++;
                    }
                }
                if(count==1){
                    answer+=1;
                }else if(count==2) {
                    answer += 10;
                }else if(count==3){
                    answer+=100;
                }else if(count==4){
                    answer+=1000;
                }
            }
        }

        System.out.println(answer);
    }

    static public void printmap(){
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(classroom[i]));
        }
    }
    static public int stoi(String s){
        return Integer.parseInt(s);

    }


}
