import java.util.*;

public class programmers_표편집 {

        // U : X칸 위의 행
        // D : X칸 아래 행
        // C : 삭제 후 바로 아래행 *삭제된 행이 마지막이면 바로 윗행
        // Z : 가장 최근에 삭제된 행을 원래대로 복구 *선택행 노바뀜

        //n : 행의 개수 k : 선택된 행의 위치 cmd : 명령들
        //LinkedList와 Stack을 활용
        public String solution(int n, int k, String[] cmd) {
            int []pre = new int[n];
            int []next = new int[n];

            // -1 == NULL
            for(int i=0;i<n;i++){
                pre[i] = i-1;
                next[i] = i+1;
            }
            next[n-1] = -1;


            StringBuilder answer = new StringBuilder("O".repeat(n));
            Stack<Node> stack= new Stack<>();

            int idx = k;

            for(String s : cmd){
                String ss[] = s.split(" ");
                String command = ss[0];

                if(command.equals("D")){
                    int move = Integer.parseInt(ss[1]);
                    while(move-- > 0){
                        idx = next[idx];
                    }

                }else if(command.equals("C")){
                    stack.push(new Node(pre[idx],idx,next[idx]));
                    //삭제되는 노드의 전 후 연결 정보 수정
                    if(pre[idx] != -1) next[pre[idx]] = next[idx];
                    if(next[idx] != -1) pre[next[idx]] = pre[idx];
                    answer.setCharAt(idx,'X');

                    if(next[idx] != -1) idx = next[idx];
                    else idx = pre[idx];

                }else if(command.equals("U")){
                    int move = Integer.parseInt(ss[1]);
                    while(move-- > 0){
                        idx = pre[idx];
                    }

                }else{ //Z
                    Node node = stack.pop();
                    //복구되는 노드의 전 후 연결 정보 수정
                    if(node.pre != -1) next[node.pre] = node.cur;
                    if(node.next != -1) pre[node.next] = node.cur;
                    answer.setCharAt(node.cur,'O');
                }

            }
            return answer.toString();
        }
        class Node{
            int pre;
            int cur;
            int next;

            public Node(int pre, int cur, int next){
                this.pre = pre;
                this.cur = cur;
                this.next = next;
            }

        }
}


