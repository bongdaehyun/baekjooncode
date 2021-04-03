class Solution {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        
        boolean gift_check[]=new boolean[100001];
        boolean want_check[]=new boolean[100001];
        
        for(int i=0;i<wants.length;i++){
            gift_check[gift_cards[i]]=true;
            want_check[wants[i]]=true;
        }
        
        for(int i=1;i<100001;i++){
            //원하는 상품을 가진 사람 수
            if(gift_check[i]&&want_check[i])
                answer++;
        }
        
        return wants.length-answer;
    }
}