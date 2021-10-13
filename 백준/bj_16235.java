import java.util.*;
import java.io.*;

//Deque로 인하여 시간초과 발생 X
public class bj_16235 {
    static int dx[]={0,-1,-1,-1,0,1,1,1};
    static int dy[]={-1,-1,0,1,1,1,0,-1};
    static int land[][],A[][];
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(in.readLine());
        n=stoi(st.nextToken()); // 맵크기
        m=stoi(st.nextToken()); // 나무
        k=stoi(st.nextToken()); // 몇년 후

        land=new int[n][n];
        A=new int[n][n];
        //로봇으로 추가되는 양분의 값과 처음 땅의 양분 설정
        for(int i=0;i<n;i++){

            st=new StringTokenizer(in.readLine());

            for(int j=0;j<n;j++){
                A[i][j]=stoi(st.nextToken());
                land[i][j]=5;
            }
        }

        Deque<Tree>trees=new ArrayDeque<>();

        //심는 나무
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int x=stoi(st.nextToken());
            int y=stoi(st.nextToken());
            int z=stoi(st.nextToken());
            trees.add(new Tree(x-1,y-1,z));
        }
        //start
        int answer=0;
        for(int i=0;i<k;i++){
            //System.out.println("i 년 후 = " + i);
            ArrayList<Tree>dead=new ArrayList<>();
            Deque<Tree>temp=new ArrayDeque<>();
            //봄
            while(!trees.isEmpty()){
                Tree tree=trees.pollFirst();
                //System.out.println(tree.toString());
                if(land[tree.x][tree.y]-tree.age<0){
                    dead.add(tree);
                }else{
                    land[tree.x][tree.y]-=tree.age;
                    tree.age+=1;
                    temp.add(tree);
                }
            }

            //여름
            for(Tree tree:dead){
                int plus=tree.age/2;
                land[tree.x][tree.y]+=plus;
            }
            //가을
            Deque<Tree>newtrees=new ArrayDeque<>();
            for(Tree tree:temp){
                newtrees.add(tree);
                if(tree.age%5==0){
                    for(int k=0;k<8;k++){
                        int nx=tree.x+dx[k];
                        int ny=tree.y+dy[k];
                        if(0<=nx&&nx<n&&0<=ny&&ny<n){
                            newtrees.addFirst(new Tree(nx,ny,1));
                        }

                    }
                }
            }
            //겨울
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    land[a][b]+=A[a][b];
                }
            }
            //newTree 이전
            trees=newtrees;
            answer= newtrees.size();
        }
        System.out.println(answer);
    }
    public static int stoi(String s){
        return Integer.parseInt(s);
    }
    static class Tree{
        int x;
        int y;
        int age;

        public Tree(int x,int y,int age){
            this.x=x;
            this.y=y;
            this.age=age;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "x=" + x +
                    ", y=" + y +
                    ", age=" + age +
                    '}';
        }
    }
}
